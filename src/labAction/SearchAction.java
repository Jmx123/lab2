package labAction;
import labAction.BookImformation;

import sql.SQLconnection;  
import com.opensymphony.xwork2.ActionSupport;  
import java.sql.*;
//import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import java.util.*;  

public class SearchAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String searchtxt;
	private String content;
	
	public String getSearchtxt(){
		return searchtxt;
	}
	
	public void setSearchtxt(String searchtxt){
		this.searchtxt = searchtxt;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String execute() throws SQLException {
		
		try {  //连接数据库
            new SQLconnection();  
        } catch (Exception e) {
            return ERROR;  
        }
		try{
			//System.out.println(content);
			if(content.equals("book"))
			{
				//查询书籍
			    PreparedStatement ps = SQLconnection.getConnection().prepareStatement("select * from book where title = '"+searchtxt+"'");
			    ResultSet rs = ps.executeQuery();
			    
			    List<BookImformation> bookList =new ArrayList<BookImformation>();
				int i = 0;
					
				while(rs.next()){
					
					String ISBN = rs.getString("ISBN");
					String Title = rs.getString("Title");
					int authorID = rs.getInt("AuthorID");
					String Publisher = rs.getString("Publisher");
					int PublishDate = rs.getInt("PublishDate");
					
					//查询作者
					PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from author where AuthorID ="+ authorID);
					ResultSet rsAuthor = psAuthor.executeQuery();
					String Author = null;  //作者名字
					String Country = null; //作者国籍
					while(rsAuthor.next()){
						Author = rsAuthor.getString("name");
						Country = rsAuthor.getString("country");
					}
					
					BookImformation b = new BookImformation(ISBN,Title,Author,Publisher,PublishDate,Country);
					bookList.add(b);
					i++;
				}
				if (i == 0)
				{
					return ERROR;
				}
					
				HttpServletRequest request = ServletActionContext.getRequest();   
				request.setAttribute("bookList", bookList); 
					
				return SUCCESS+"book";
			}
			else
			{
				//查询作者ID
				 PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from author where name = '"+searchtxt+"'");
				 ResultSet rsAuthor = psAuthor.executeQuery();
				 
				 List<BookImformation> bookList =new ArrayList<BookImformation>();
				 int i = 0;  //记录书籍数量
				 
				 //可能有作者同名
				 while(rsAuthor.next()){
					 int authorID = rsAuthor.getInt("AuthorID");
					 String country = rsAuthor.getString("Country");
					 
					 PreparedStatement psBook = SQLconnection.getConnection().prepareStatement("select * from book where AuthorID = "+authorID);
					 ResultSet rsBook = psBook.executeQuery();
					 
					 //每位作者都可能有多本著作
					 while(rsBook.next()){
						 String ISBN = rsBook.getString("ISBN");
						 String Title = rsBook.getString("Title");
						 String Publisher = rsBook.getString("Publisher");
						 int PublishDate = rsBook.getInt("PublishDate");
						 BookImformation b = new BookImformation(ISBN,Title,searchtxt,Publisher,PublishDate,country);
						 
						 bookList.add(b);
						 i++;
					 }
				 }
				
				 if (i == 0)  //没有查询到
					return ERROR;
				 
				 HttpServletRequest request = ServletActionContext.getRequest();   
				 request.setAttribute("bookList", bookList); 
						
				 return SUCCESS+"author";
			}
			
		}catch(SQLException e){
			//System.out.println(e.toString());
			return ERROR;
		}finally{
			SQLconnection.CloseCon();
		}
		//return INPUT;
		
	}
}
