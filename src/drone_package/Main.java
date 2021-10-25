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
import drone_package.objects.User;

public class Main {
	// Main function
	public static void main(String[] args) throws SQLException {
//		new WelcomeWindow();
		DronePostDB db = new DronePostDB();
//		User u1 = new User("tali", "nahariya", "4400", 30);
//		db.insertUser(u1);
		ResultSet rs = db.query("select * from users WHERE name = " + "'shali'");
		rs.next();
		System.out.println(rs.getString("name"));
//		rs.next();
//		System.out.println(rs.getString("name"));
		db.close();
	}
}
