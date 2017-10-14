package labAction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import sql.SQLconnection;

public class UpdateAuthorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String country;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAge(){
		return age;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public String getCountry(){
		return country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
    public String execute() throws SQLException {
		
		//System.out.println(1);
		try {  //连接数据库
            new SQLconnection();  
        } catch (Exception e) {
            return ERROR;  
        }
		
		try{
			
			int authorID=0;
			PreparedStatement psAuthor = SQLconnection.getConnection().prepareStatement("select * from author where name = '"+name+"'");
		    ResultSet rsAuthor = psAuthor.executeQuery();
		    while(rsAuthor.next()){  //得到作者的ID
		    	authorID = rsAuthor.getInt("AuthorID");
		    }
			
			if(age != null&&!age.equals(""))
			{
				 PreparedStatement psAge = SQLconnection.getConnection().prepareStatement("update author set age ='"+age+"' where authorID = "+authorID);
				 psAge.executeUpdate();
			}
			
			if(country != null&&!country.equals(""))
			{
				 PreparedStatement psCountry = SQLconnection.getConnection().prepareStatement("update author set country ='"+country+"' where authorID = "+authorID);
				 psCountry.executeUpdate();
			}
			
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}finally{
			SQLconnection.CloseCon();
		}
    }
}
