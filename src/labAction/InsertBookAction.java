package labAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import sql.SQLconnection;

public class InsertBookAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String isbn;
	private String author;
	private String publisher;
	private String publishdate;
	private String price;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public void setPublisher(String publisher){
		this.publisher = publisher;
	}
	
	public String getPublishdate(){
		return publishdate;
	}
	
	public void setPublishdate(String publishdate){
		this.publishdate = publishdate;
	}
	
	public String getPrice(){
		return price;
	}
	
	public void setPrice(String price){
		this.price = price;
	}
	
	//��ں���
	public String execute() throws SQLException {
		
		HttpServletRequest request = ServletActionContext.getRequest();   
		
		try {  //�������ݿ�
            new SQLconnection();  
        } catch (Exception e) {
        	request.setAttribute("error", e.toString()); 
            return ERROR;  
        }
		
		try{
			System.out.println(isbn.length());
			//�ж�isbn�����Ƿ���ȷ
			if (isbn.length() == 13)  //10λ����ISBN��
			{
				int isbnSum = 0;
				int isbnNum = 0;
				int weight = 10;
				String check = "";
				for(int i = 0;i < 11;i++)
				{
					char temp = isbn.charAt(i);
					if (temp <= '9' && temp >= '0')
					{
						isbnSum += Integer.parseInt(isbn.substring(i, i+1)) * weight;
						weight--;
					}
				}
				isbnNum = 11 - isbnSum % 11;
				if(isbnNum == 10){
					check = "X";
				}
				else if(isbnNum == 11)
				{
					check = "0";
				}
				else{
					check = ""+isbnNum;
				}
				if(!check.equals(isbn.substring(12)))
				{
					return INPUT;
				}
			}
			else if(isbn.length() == 17)  //13λ����У����
			{
				int isbnSum = 0;
				int isbnNum = 0;
				String check = "";
				int weight = 1;
				for(int i = 0;i < 15;i++)
				{
					char temp = isbn.charAt(i);
					if (temp <= '9' && temp >= '0')
					{
						isbnSum += Integer.parseInt(isbn.substring(i, i+1)) * weight;
						if (weight == 1){
							weight = 3;
						}
						else{
							weight = 1;
						}
					}
				}
				isbnNum = 10 - isbnSum % 10;
				if(isbnNum == 10){
					check = "0";
				}
				else{
					check = ""+isbnNum;
				}
				System.out.println(":"+check);
				System.out.println("ʵ��:"+isbn.substring(16));
				if(!check.equals(isbn.substring(16)))
				{
					return INPUT;
				}
			}
			else{
				return INPUT;
			}
			
			//��ѯͼ���Ƿ��Ѵ���
			PreparedStatement psBook = SQLconnection.getConnection().prepareStatement("select * from book where isbn = '"+isbn+"'");
		    ResultSet rsBook = psBook.executeQuery();
		    while(rsBook.next()){
		    	return INPUT;
		    }
			
			//��ѯ�����Ƿ����
			PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from author where name = '"+author+"'");
		    ResultSet rsAuthor = psAuthor.executeQuery();
		    
		    int authorID = 0;
		    while(rsAuthor.next()){
		    	authorID = rsAuthor.getInt("authorid");
		    }
		    //���߲����ڣ��������
		    if(authorID == 0)
		    {
		    	//�ҵ�����authorid
		    	PreparedStatement psAuthoridMax = SQLconnection.getConnection().prepareStatement("select max(authorid) from author");
		    	ResultSet rsAuthoridMax = psAuthoridMax.executeQuery();
		    	while(rsAuthoridMax.next()){
		    		authorID = rsAuthoridMax.getInt("max(authorid)")+1;
		    	}
		    	//�������
		    	PreparedStatement psInsertAuthor = SQLconnection.getConnection().prepareStatement("insert into author (authorid,name) values ('"+authorID+"','"+author+"')");
		    	psInsertAuthor.executeUpdate();
		    }
		    
		    //���ͼ��
		    PreparedStatement psInsertBook = SQLconnection.getConnection().prepareStatement(
		    		"insert into book (ISBN,title,authorid,Publisher,PublishDate,Price) values ('"+isbn+"','"+title+"','"+authorID+"','"+publisher+"','"+publishdate+"','"+price+"')");
		    psInsertBook.executeUpdate();
		    
		    return SUCCESS;
		    
		}catch(Exception e){
			request.setAttribute("error", e.toString()); 
			return ERROR;
		}finally{
			SQLconnection.CloseCon();
		}
	}

}
