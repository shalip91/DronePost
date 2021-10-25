package drone_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.sql.Connection;

import drone_package.DataBase.DBConnection;
import drone_package.GUI.WelcomeWindow;
import drone_package.objects.Drone;

public class Main {
	// Main function
	public static void main(String[] args) {
//		new WelcomeWindow();
		Connection conn;
		try {
			conn = DBConnection.getConn();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
