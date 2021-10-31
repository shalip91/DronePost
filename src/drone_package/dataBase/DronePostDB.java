package drone_package.dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import drone_package.objects.Drone;
import drone_package.objects.Message;
import drone_package.objects.Order;
import drone_package.objects.User;

import java.util.ArrayList;


public class DronePostDB extends DBConnection{
	private PreparedStatement preStmt;
	
	public DronePostDB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void insertUser(User user) throws SQLException {
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
			throw e;
		}
		
	}
	
	// add new Order to SQL server
	public void insertOrder(Order order) {
		String query = "insert into orders (src_name, dst_name, order_date)" + "values (?, ?, ?)";
		try {
			this.preStmt = (PreparedStatement) this.conn.prepareStatement(query);
			this.preStmt.setString(1, order.getSrcName());
			this.preStmt.setString(2, order.getDstName());
			this.preStmt.setTimestamp(3, order.getDateTime());
			this.preStmt.execute(); // can allso be executeUpdate()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertDrone(Drone drone) {
		String query = "insert into drones (drone_id, is_available, battery_percentage)" + "values (?, ?, ?)";
		try {
			this.preStmt = (PreparedStatement) this.conn.prepareStatement(query);
			this.preStmt.setInt(1, drone.getId());
			this.preStmt.setBoolean(2, drone.isAvailable());
			this.preStmt.setInt(3, drone.getBatteryPercentage());
			this.preStmt.execute(); // can allso be executeUpdate()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// not working yet
	public void insertMessage(Message message) {
		String query = "insert into message (message_id, src_name, dst_name, content, date_time)" + "values (?, ?, ?, ?, ?)";
		try {
			this.preStmt = (PreparedStatement) this.conn.prepareStatement(query);
			this.preStmt.setInt(1, message.getId());
			this.preStmt.setString(2, message.getSender());
			this.preStmt.setString(3, message.getReceiver());
			this.preStmt.setString(4, message.getContent());
			this.preStmt.setTimestamp(5, message.getDateTime());
			this.preStmt.execute(); // can allso be executeUpdate()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// receive history of messages from SQL server
	public void getMessages(String[][] dataTable, String name) {
		 ResultSet rs = this.query("select * from message WHERE src_name = " + "'" + name + "'" + " OR dst_name = " + "'" + name + "'");
		try {
			int i = 0;
			while(rs.next()) {
				dataTable[i][0] = (rs.getString("date_time"));
				dataTable[i][1] = (rs.getString("src_name")); 
				dataTable[i][2] = (rs.getString("dst_name"));
				dataTable[i][3] = (rs.getString("content"));
				++i;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.close();	
	}

	
	// decrease count of order for user in SQL server
	public void decreaseOrder(String name) {
		String query = "update users set orders = ? where name = ?";
		DronePostDB db = new DronePostDB();
		ResultSet rs = db.query("select * from users WHERE name = " + "'" + name + "'");
		try {
			rs.next();
			int oldValue = rs.getInt("orders");
			this.preStmt = (PreparedStatement) this.conn.prepareStatement(query);
			this.preStmt.setInt(1, oldValue-1);
			this.preStmt.setString(2, name);
			this.preStmt.executeUpdate(); // can allso be executeUpdate()
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		db.close();		
	}

	// receive history of user from SQL server
	public void getOrders(String[][] dataTable, String name, String sentOrReceived) {
		ResultSet rs;
		if (sentOrReceived == "sent") {
			rs = this.query("select * from orders WHERE src_name = " + "'" + name + "'");
		}
		else {
			rs = this.query("select * from orders WHERE dst_name = " + "'" + name + "'");
		}
		
		try {
			int i = 0;
			while(rs.next()) {
				dataTable[i][0] = (rs.getString("date_time"));
				dataTable[i][1] = (rs.getString("src_name"));
				dataTable[i][2] = (rs.getString("dst_name"));
				++i;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.close();	
	}

	// needed for updating total order count for updating new orders to SQL server
	public int getOrdersIdCount() {
		int count = 0;
		ResultSet rs = this.query("select * from orders");// WHERE src_name = " + "'" + name + "'");
		try {
			while(rs.next()) {
				++count;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.close();	
		return count;
	}

	// needed for updating total order count for updating new orders to SQL server
	public int getMessageCount() {
		int count = 0;
		ResultSet rs = this.query("select * from message");// WHERE src_name = " + "'" + name + "'");
		try {
			while(rs.next()) {
				++count;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.close();	
		return count;
	}

}
