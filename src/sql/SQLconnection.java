package sql;
import java.sql.*;

public class SQLconnection {

	private static Connection conn = null;  
    //连接地址  
    String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_bookdb?characterEncoding=utf-8&useOldAliasMetadataBehavior=true";  
    //?useOldAliasMetadataBehavior=true
    // MySQL用户名  
    String user = "mxnmjoyxok";  
    // MySQL密码  
    String password = "5l3y23zhy5l43k1z4kz3hjmhjk5xjyz3y5m3z3xi";  
  
     public SQLconnection() throws Exception {  
        Class.forName("com.mysql.jdbc.Driver");  
        conn=DriverManager.getConnection(url,user,password);  
    }  
      
    //获得连接对象  
    public static Connection getConnection(){  
        return conn;  
    }  
      
    //关闭连接  
    public static void CloseCon() throws SQLException{  
        conn.close();  
    }
}
