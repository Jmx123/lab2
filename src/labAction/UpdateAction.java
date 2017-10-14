package labAction;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import labAction.book;
import com.opensymphony.xwork2.ActionSupport;

import sql.SQLconnection;

public class UpdateAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String author;
	private String publisher;
	private String publishDate;
	private String price;
	//接受数据
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
	
	public String getPublishDate(){
		return publishDate;
	}
	
	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}
	
	public String getPrice(){
		return price;
	}
	
	public void setPrice(String price){
		this.price = price;
	}
	
	
	
	public String execute() throws SQLException {
		
		//System.out.println(1);
		try {  //连接数据库
            new SQLconnection();  
        } catch (Exception e) {
            return "fail";  
        }
		
		try{
			int date=0;
			float Price=0;
			if(author != null&&!author.equals(""))
			{
				//System.out.println(author);
				//更改作者名字ID不变但是ID名字改变
				int authorID=0;
				PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from book where ISBN = '"+isbn+"'");
			    ResultSet rsAuthor = psAuthor.executeQuery();
			    while(rsAuthor.next()){  //得到作者的ID
			    	authorID = rsAuthor.getInt("AuthorID");
			    }
			    
			    //更改ID对应的名字
			    PreparedStatement psAuthorIDUp = SQLconnection.getConnection().prepareStatement("update author set name ='"+author+"' where authorID = "+authorID);
			    psAuthorIDUp.executeUpdate();
			}
			
			if(publisher != null&&!publisher.equals(""))
			{
				PreparedStatement psPublisherUp = SQLconnection.getConnection().prepareStatement("update book set Publisher = '"+publisher+"' where ISBN = '"+isbn+"'");
			    //ResultSet rsPublisherUp = 
				psPublisherUp.executeUpdate();
			    
			}
			
			if(publishDate != null&&!publishDate.equals(""))
			{
				date = Integer.parseInt(publishDate);
				//System.out.println(date);
				PreparedStatement psPublishDateUp = SQLconnection.getConnection().prepareStatement("update book set PublishDate = '"+date+"' where ISBN = '"+isbn+"'");
			    //ResultSet rsPublishDateUp = 
				psPublishDateUp.executeUpdate();
			}
			
			if(price != null&&!price.equals(""))
			{
				Price = Float.parseFloat(price);
				PreparedStatement psPriceUp = SQLconnection.getConnection().prepareStatement("update book set Price = "+Price+" where ISBN = '"+isbn+"'");
			    //ResultSet rsPriceUp = 
			    psPriceUp.executeUpdate();
			}
			
			
			//得到更新之后数据输出到页面
			int authorid = 0;
			String title = "";
			PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from book where ISBN = '"+isbn+"'");
		    ResultSet rsAuthor = psAuthor.executeQuery();
		    while(rsAuthor.next()){  //得到修改后的数据
		    	title = rsAuthor.getString("title");
		    	authorid = rsAuthor.getInt("authorID");
		    	publisher = rsAuthor.getString("publisher");
		    	date = rsAuthor.getInt("publishDate");
		    	//System.out.println(date);
		    	Price = rsAuthor.getFloat("price");
		    }
		    	
		  //作者名字
		    PreparedStatement ps = SQLconnection.getConnection().prepareStatement("select * from author where authorID = "+authorid);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()){  //得到作者的ID
		    	author = rs.getString("name");
		    }
		    
		    book bookupdate = new book(isbn,title,author,publisher,date,Price);
		    HttpServletRequest request = ServletActionContext.getRequest();   
			request.setAttribute("bookupdate", bookupdate);
		    
			return SUCCESS;
		}catch(Exception e){
			System.out.println(e.toString());
			return "fail";
		}finally{
			SQLconnection.CloseCon();
		}
	}
}
