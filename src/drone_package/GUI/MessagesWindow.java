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
import drone_package.objects.Message;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MessagesWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JTable messageTable;
	private JScrollPane ScrollableTable;
	private JLabel messageLabel = new JLabel("My messages");
	private JLabel dstLabel = new JLabel("Receiver Name:");
	private JLabel sendMessageLabel = new JLabel("Your message:");
	private JTextField dstText = new JTextField();
	private JTextField messageText = new JTextField();
	private JButton sendButton = new JButton("Send");
	private JButton returnButton = new JButton("Return");
	private int H = 600;
	private int W = 500;
	private String userName;

	public MessagesWindow(String name) {
		userName = name;
		createMyWindow();
		getMessagesFromServer();
		addComponents();
		setLocation();
		actionEventFunc();
	}

	public void createMyWindow()
	{
		frame = new JFrame();
		frame.setTitle("My Messages");
		frame.setBounds(0,0,W,H);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(240,250,243));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void addComponents()
	{
		frame.add(messageLabel);
		frame.add(ScrollableTable);
		frame.add(dstLabel);
		frame.add(dstText);
		frame.add(sendMessageLabel);
		frame.add(messageText);
		frame.add(sendButton);
		frame.add(returnButton);
	}

	public void setLocation()
	{
		int x = W/2 - 80;
		int y = 10;
		messageLabel.setFont(new Font("Serif", Font.BOLD, 30));
		messageLabel.setBounds( x, y, 200, 30);

		x = (W/10);
		y += 30 + H/30;
		ScrollableTable.setBounds(x , y, (int)(W - (2 * (W/10))), H/4);
    	ScrollableTable.setVisible(true);
		
		dstLabel.setFont(new Font("Serif", Font.BOLD, 20));
		dstLabel.setBounds(x ,250 ,300 , 30);		
		
		dstText.setFont(new Font("Serif", Font.BOLD, 20));
		dstText.setBounds(x ,280 ,200 , 30);

		sendMessageLabel.setFont(new Font("Serif", Font.BOLD, 20));
		sendMessageLabel.setBounds(x ,310 ,300 , 30);		

		messageText.setFont(new Font("Serif", Font.BOLD, 20));
		messageText.setBounds(x ,340 , 400 , 30);

		sendButton.setFont(new Font("Serif", Font.BOLD, 25));
		sendButton.setBounds(x ,380 , 100, 30);

		returnButton.setFont(new Font("Serif", Font.BOLD, 30));
		returnButton.setBounds(W/4,500 , W/2, H/15);
	}


	public void actionEventFunc()
	{
		returnButton.addActionListener(this);
		sendButton.addActionListener(this);
	}


	public void getMessagesFromServer() {
		
		String[] headers = { "Date", "From", "To", "Message"};
		String[][] TableData = new String[50][4];

		DronePostDB db = new DronePostDB();
		db.getMessages(TableData, userName);
		messageTable = new JTable(TableData, headers);
		ScrollableTable = new JScrollPane(messageTable);
				
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// return button - go to previous screen
		if(e.getSource() == returnButton) {
			frame.dispose();
			new InnerAppWindow(this.userName);
		}
		
		// send button - check if destination user exist in the system
		if(e.getSource() == sendButton) {
		
			String dstName = dstText.getText();
			DronePostDB db = new DronePostDB();
			ResultSet rs = db.query("select * from users WHERE name = " + "'" + dstName + "'");
			try {
				if (rs.next()) {

					frame.dispose();
					db = new DronePostDB();
					Message message = new Message(this.userName, this.dstText.getText(), this.messageText.getText());
					db.insertMessage(message);
					new MessagesWindow(this.userName);

				} else {
					JOptionPane.showMessageDialog(frame, "there is no such user in the system");
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}


		}
	}


}