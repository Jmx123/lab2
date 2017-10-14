package labAction;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import sql.SQLconnection;

public class ShowBookAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws SQLException {
		HttpServletRequest request= ServletActionContext.getRequest(); 
		String isbn = request.getParameter("isbn");
		
		try {  //连接数据库
            new SQLconnection();  
        } catch (Exception e) {
			request.setAttribute("error", e.toString());
            return ERROR;  
        }
		
		try{
			//图书信息
			String Title="";
			String Publisher="";
			int PublishDate=0;
			float Price=0;
			int AuthorID=0;
			
			//作者信息
			String name="";
			int sqlage=0;
			String country="";
			
			//查询图书信息
			PreparedStatement psBook = SQLconnection.getConnection().prepareStatement("select * from book where ISBN = '"+isbn+"'");
		    ResultSet rsBook = psBook.executeQuery();
		    while (rsBook.next()){
		    	Title = rsBook.getString("title");
		    	AuthorID = rsBook.getInt("authorID");
		    	Publisher = rsBook.getString("Publisher");
		    	PublishDate = rsBook.getInt("PublishDate");
		    	Price = rsBook.getFloat("price");
		    }
			
		    //查询作者信息
		    PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from author where AuthorID = "+AuthorID);
		    ResultSet rsAuthor = psAuthor.executeQuery();
		    while(rsAuthor.next()){
		    	name = rsAuthor.getString("name");
		    	sqlage = rsAuthor.getInt("age");
		    	country = rsAuthor.getString("country");
		    }
		    
		    book book = new book(isbn,Title,name,Publisher,PublishDate,Price);
			request.setAttribute("book", book);
			String age = "";
			if (sqlage==0)
				age = "无信息";
			else
				age = sqlage+"";
			if(country.equals(""))
			{
				country = "无信息";
			}
			author author = new author(AuthorID,name,age,country);
			request.setAttribute("author", author);
			return SUCCESS;
		}catch(Exception e){
			request.setAttribute("error", e.toString());
			return ERROR;
		}finally{
			SQLconnection.CloseCon();
		}
		
	}

}
