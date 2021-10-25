package drone_package.dataBase;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import drone_package.objects.Order;
import drone_package.objects.User;

public class DronePostDB extends DBConnection{
	private PreparedStatement preStmt;
	
	public DronePostDB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void insertUser(User user) {
		String query = "insert into users (name, addr, phone, orders)" + "values (?, ?, ?, ?)";
		try {
			this.preStmt = (PreparedStatement) this.conn.prepareStatement(query);
			this.preStmt.setString(1, user.getName());
			this.preStmt.setString(2, user.getAddr());
			this.preStmt.setString(3, user.getPhoneNumber());
			this.preStmt.setInt(4, user.getOrders());
			this.preStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public void insertOrder(Order order) {
//		String query = "insert into orders (id, srcName, dstName, date)" + "values (?, ?, ?, ?)";
//		try {
//			this.preStmt = (PreparedStatement) this.conn.prepareStatement(query);
//			this.preStmt.setString(1, user.getName());
//			this.preStmt.setString(2, user.getAddr());
//			this.preStmt.setString(3, user.getPhoneNumber());
//			this.preStmt.setInt(4, user.getOrders());
//			this.preStmt.execute();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
