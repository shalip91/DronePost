package drone_package.DataBase;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
public class DBConnection {  
	public static Connection conn;  
	public static Connection getConn() throws ClassNotFoundException  {   
		try{    
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dronepost","root","");    
			System.out.println("Connected...");    
			return conn;   
			}
		catch(SQLException e){    
			System.out.println(e);    
			return null;   
		}  
	} 
} 