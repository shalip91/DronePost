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



public class MessagesWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JTable messageTable;
	private JScrollPane ScrollableTable;
	private JLabel messageLabel = new JLabel("My messages");
	private JLabel dstLabel = new JLabel("Receiver Name");
	private JTextField dstText = new JTextField();
	private JTextField message = new JTextField();
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
		frame.add(messageLabel);
		frame.add(ScrollableTable);
		frame.add(dstLabel);
		frame.add(dstText);
		frame.add(message);
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
		
		y += H/4;
		dstLabel.setFont(new Font("Serif", Font.BOLD, 30));
		dstLabel.setBounds(W/20, y, (int)(W/2), H/6);		

		y += 10 + H/12;
		dstText.setFont(new Font("Serif", Font.BOLD, 30));
		dstText.setBounds(x ,y , 400 , H/12);

		y += 10 + H/12;
		message.setFont(new Font("Serif", Font.BOLD, 30));
		message.setBounds(x ,y , 400 , H/12);

		y += H/12;
		sendButton.setFont(new Font("Serif", Font.BOLD, 30));
		sendButton.setBounds(W/4, y, W/2, H/15);

		returnButton.setFont(new Font("Serif", Font.BOLD, 30));
		returnButton.setBounds(W/4, (int)(H/1.2) , W/2, H/15);
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
		boolean validDst = true;
		if(e.getSource() == returnButton) {
			frame.dispose();
			new InnerAppWindow(this.userName);
		}
		if(e.getSource() == sendButton) {
			frame.dispose();
			DronePostDB db = new DronePostDB();
			Message message = new Message(this.userName, this.dstText.getText(), this.message.getText());
			db.insertMessage(message);
			new InnerAppWindow(this.userName);
		}
	}


}