package sql;
import java.sql.*;

public class SQLconnection {

	private static Connection conn = null;  
    //���ӵ�ַ  
    String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_bookdb?characterEncoding=utf-8&useOldAliasMetadataBehavior=true";  
    //?useOldAliasMetadataBehavior=true
    // MySQL�û���  
    String user = "mxnmjoyxok";  
    // MySQL����  
    String password = "5l3y23zhy5l43k1z4kz3hjmhjk5xjyz3y5m3z3xi";  
  
     public SQLconnection() throws Exception {  
        Class.forName("com.mysql.jdbc.Driver");  
        conn=DriverManager.getConnection(url,user,password);  
    }  
      
    //������Ӷ���  
    public static Connection getConnection(){  
        return conn;  
    }  
      
    //�ر�����  
    public static void CloseCon() throws SQLException{  
        conn.close();  
    }
}
