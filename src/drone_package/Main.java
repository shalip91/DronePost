package drone_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import drone_package.GUI.WelcomeWindow;
import drone_package.dataBase.DBConnection;
import drone_package.dataBase.DronePostDB;
import drone_package.objects.Drone;
import drone_package.objects.Message;
import drone_package.objects.Order;
import drone_package.objects.User;

import java.time.LocalDateTime;

public class Main {
	// Main function
	public static void main(String[] args) throws SQLException {
		DroneSystem DS = DroneSystem.getInstance();
		new WelcomeWindow();
//		DronePostDB db = new DronePostDB();
////		User u1 = new User("tali", "nahariya", "4400", 30);
////		db.insertUser(u1);
////		ResultSet rs = db.query("select * from users WHERE name = " + "'shali'");
////		rs.next();
////		System.out.println(rs.getString("name"));
////		rs.next();
////		System.out.println(rs.getString("name"));
//		
//		Order o = new Order("shali", "oz");
//		Order o = new Order("shali", "tali");
//		Order o = new Order("shali", "guy");
//		db.insertOrder(o);
//		ResultSet rs2 = db.query("select * from orders WHERE src_name = " + "'shhhhali'");
//		while (rs2.next()) {
//			System.out.println(rs2.getString("src_name") + " " + rs2.getString("dst_name"));	
//		}		
//
//		Message m1 = new Message("shali", "he man");
//		Message m2 = new Message("shali", "he big man");
//		Message m3 = new Message("tali", "he woman");
//		Message m4 = new Message("shali", "what's up man???");
////		db.insertMessage(m4);
//		ResultSet rs3 = db.query("select * from message WHERE receiver = " + "'shali'");
//		while (rs3.next()) {
//			System.out.println(rs3.getString("receiver") + " " + rs3.getString("content"));	
//		}	
		
//		db.close();
	}
}
