package drone_package.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import drone_package.DroneSystem;
import drone_package.dataBase.DronePostDB;
import drone_package.details.MyBoolHolder;
import drone_package.objects.Order;
import drone_package.objects.Message;

import java.lang.Math;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignDroneWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JLabel titleLabel = new JLabel("Assign Drone");
	private JLabel dstLabel = new JLabel("Receiver Name");
	private JTextField dstText = new JTextField();
	private JButton sendButton = new JButton("Send");
	private int H = 600;
	private int W = 500;
	
	private String userName;
	private MyBoolHolder droneArrived;
	
	public AssignDroneWindow(String name, MyBoolHolder droneArrived) {
		this.userName = name;
		this.droneArrived = droneArrived;
		createMyWindow();
		setLocation();
		addComponents();
		actionEventFunc();
	}
	public void createMyWindow()
	{
		frame=new JFrame();
		frame.setTitle("Assign Drone");
		frame.setBounds(0,0,W,H);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(
				         dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(240,250,243));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void addComponents()
	{
		frame.add(titleLabel);
		frame.add(dstLabel);
		frame.add(dstText);
		frame.add(sendButton);
	}
	
	public void setLocation()
	{
		
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		titleLabel.setBounds((int)(W/4.2), H/30, (int)(W/1.2), H/10);
		
		dstLabel.setFont(new Font("Serif", Font.BOLD, 30));
		dstLabel.setBounds(W/20, (int)(H/3.5), (int)(W/2), H/6);		
	
		dstText.setFont(new Font("Serif", Font.BOLD, 30));
		dstText.setBounds((int)(W/2.1),H/3, (int)(W/2.2) , H/12);

		sendButton.setFont(new Font("Serif", Font.BOLD, 30));
		sendButton.setBounds(W/4, H/2 + H/10, W/2, H/15);
	}
	

	public void actionEventFunc()
	{
		sendButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean validDst = true;
		if(e.getSource() == sendButton) {
			String dstName = dstText.getText();
			DronePostDB db = new DronePostDB();
			ResultSet rs = db.query("select * from users WHERE name = " + "'" + dstName + "'");
			try {
				if (rs.next()) { // the destination user exists. 
					DroneSystem.getInstance().assigneDrone(frame, droneArrived.getDroneId());
					db.decreaseOrder(this.userName);
					db.insertOrder(new Order(this.userName, dstName));
					db.close();
					frame.dispose();
					new InnerAppWindow(this.userName);
				} else {
					JOptionPane.showMessageDialog(frame, "There is no such user in the system");

					db = new DronePostDB();
					db.insertMessage(new Message("System Manager", this.userName, "There is no such user (" + dstName + ") in the system"));

					frame.dispose();
					new AssignDroneWindow(this.userName, this.droneArrived);
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	
}