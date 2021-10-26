package drone_package.dataBase;
import java.sql.Connection; 

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement; 
public class DBConnection {  
	protected Connection conn;  
	private Statement stmt;
	private ResultSet rs;
	
	public DBConnection() {
		super();
		this.conn = this.getConn();
	}

	private Connection getConn() {   
		try{    
			Class.forName("com.mysql.jdbc.Driver"); 
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/dronepost","root","");    
		} catch(SQLException e){
			System.out.println(e);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	} 
	
	public ResultSet query(String q){
		
		try {
			this.stmt = (Statement) this.conn.createStatement();
			this.rs = stmt.executeQuery(q);
			return rs;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
} 