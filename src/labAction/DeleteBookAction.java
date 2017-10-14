package labAction;

import java.sql.*;
import java.sql.SQLException;
//import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import sql.SQLconnection;

public class DeleteBookAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String execute() throws SQLException {
		HttpServletRequest request= ServletActionContext.getRequest(); 
		String isbn = request.getParameter("isbn");
		//System.out.println(isbn);
		//System.out.println(1);
		
		try {  //连接数据库
            new SQLconnection();  
        } catch (Exception e) { 
			request.setAttribute("error", e.toString());
            return ERROR;  
        }
		
		try{
			PreparedStatement psDelete = SQLconnection.getConnection().prepareStatement("delete from book where ISBN = '"+isbn+"'");
		    psDelete.executeUpdate();
			
			return SUCCESS;
		}catch(Exception e){
			request.setAttribute("error", e.toString());
			return ERROR;
		}finally{
			SQLconnection.CloseCon();
		}
		
	}
	

}
