package drone_package.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.Math;

import javax.swing.JTable;
import drone_package.dataBase.DronePostDB;
import java.util.ArrayList;
import javax.swing.table.TableModel;



public class HistoryWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JTable sentDronesTable;
	private JTable receivedDronesTable;
	private JScrollPane sentDronesScrollableTable;
	private JScrollPane receivedDronesScrollableTable;

	private JLabel sentDroneLabel = new JLabel("Sent");
	private JLabel receivedDroneLabel = new JLabel("Received");
	private JButton returnButton = new JButton("Return");
	private int H = 600;
	private int W = 500;
	private String userName;

	public HistoryWindow(String name) {
		userName = name;

		createMyWindow();
		getDataFromServer();
		addComponents();
		setLocation();
		actionEventFunc();
	}

	public void createMyWindow()
	{
		frame=new JFrame();
		frame.setTitle("History is Mystery");
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
		frame.add(sentDroneLabel);
		frame.add(sentDronesScrollableTable);
		frame.add(receivedDroneLabel);
		frame.add(receivedDronesScrollableTable);
		frame.add(returnButton);
	}

	public void setLocation()
	{
		int x = W/2 - 40;
		int y = 10;
		sentDroneLabel.setFont(new Font("Serif", Font.BOLD, 30));
		sentDroneLabel.setBounds( x, y, 100, 30);

		x = (W/10);
		y += 30 + H/30;
		sentDronesScrollableTable.setBounds(x , y, (int)(W - (2 * (W/10))), H/4);
    	sentDronesScrollableTable.setVisible(true);
		
		x = W/2 - 60;
		y += H/4 + H/30;
		receivedDroneLabel.setFont(new Font("Serif", Font.BOLD, 30));
		receivedDroneLabel.setBounds( x, y, 200, 30);
		
		x = (W/10);
		y +=  H/30 + 30;
		receivedDronesScrollableTable.setBounds(x, y, (int)(W - (2 * (W/10))), H/4);
    	receivedDronesScrollableTable.setVisible(true);


		returnButton.setFont(new Font("Serif", Font.BOLD, 30));
		returnButton.setBounds(W/4, (int)(H/1.2) , W/2, H/15);
	}


	public void actionEventFunc()
	{
		returnButton.addActionListener(this);
	}


	public void getDataFromServer() {
		
		String[] headers = { "Date", "From", "To" };
		String[][] sentTableData = new String[50][3];
		String[][] receivedTableData = new String[50][3];

		DronePostDB db = new DronePostDB();
		db.getOrders(sentTableData, userName, "sent");
		sentDronesTable = new JTable(sentTableData, headers);
		sentDronesScrollableTable = new JScrollPane(sentDronesTable);
		
		db = new DronePostDB();
		db.getOrders(receivedTableData, userName, "received");
		receivedDronesTable = new JTable(receivedTableData, headers);
		receivedDronesScrollableTable = new JScrollPane(receivedDronesTable);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean validDst = true;
		if(e.getSource() == returnButton) {
			frame.dispose();
			new InnerAppWindow(this.userName);
			// new WelcomeWindow();
		}
	}


}