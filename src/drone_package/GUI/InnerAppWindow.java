package drone_package.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import drone_package.dataBase.DronePostDB;

import java.lang.Math;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InnerAppWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JLabel titleLabel = new JLabel("Personal Space");
	private JLabel nameLabel;
	private JLabel orderLabel;
	private JButton summonDronButton = new JButton("Summon Drone");
	private JButton assignDronButton = new JButton("Assign Drone");
	private JButton histroyButton = new JButton("History");
	private int H = 600;
	private int W = 500;
	private boolean droneArrived = false;
	private String userName;
	
	public InnerAppWindow(String name) {
		DronePostDB db = new DronePostDB();
		ResultSet rs = db.query("select * from users WHERE name = " + "'" + name + "'");
		
		this.userName = name;
		nameLabel = new JLabel("Welcome " + 
				name.substring(0, 1).toUpperCase() + name.substring(1) + " !");
		try {
			rs.next();
			orderLabel = new JLabel("Remaining Orders: " + rs.getInt("orders"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		createMyWindow();
		setLocation();
		addComponents();
		actionEventFunc();
	}
	
	public void createMyWindow()
	{
		frame=new JFrame();
		frame.setTitle("Personal Space");
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
		frame.add(nameLabel);
		frame.add(orderLabel);
		frame.add(summonDronButton);
		frame.add(assignDronButton);
		frame.add(histroyButton);
	}
	
	public void setLocation()
	{
		
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		titleLabel.setBounds((int)(W/4.2), H/30, (int)(W/1.2), H/10);

		nameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		nameLabel.setBounds(W/20, (int)(H/10), (int)(W/1.2), H/6);
		
		orderLabel.setFont(new Font("Serif", Font.BOLD, 30));
		orderLabel.setBounds(W/20, (int)(H/6.5), (int)(W/1.2), H/6);

		summonDronButton.setFont(new Font("Serif", Font.BOLD, 30));
		summonDronButton.setBounds(W/4, H/2 - H/10, W/2, H/15);
		
		assignDronButton.setFont(new Font("Serif", Font.BOLD, 30));
		assignDronButton.setBounds(W/4, H/2, W/2, H/15);
		
		histroyButton.setFont(new Font("Serif", Font.BOLD, 30));
		histroyButton.setBounds(W/4, H/2 + H/10, W/2, H/15);
	}
	

	public void actionEventFunc()
	{
		summonDronButton.addActionListener(this);
		assignDronButton.addActionListener(this);
		histroyButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == summonDronButton) {
			
			JOptionPane.showMessageDialog(frame, "Drone has arrived");
			droneArrived = true;	
		}
		if(e.getSource() == assignDronButton) {
			if (droneArrived) {
				frame.dispose();
				new AssignDroneWindow(this.userName);
			}
			else {
				JOptionPane.showMessageDialog(frame, "You need to summon drone.");
			}
		}
		if (e.getSource() == histroyButton) {
			frame.dispose();
			new HistoryWindow();
		}

	}
	
	
}