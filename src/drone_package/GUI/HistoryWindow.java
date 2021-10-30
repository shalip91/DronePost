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

	private JButton returnButton = new JButton("Return");
	private int H = 600;
	private int W = 500;
	private String userName;

	public HistoryWindow() {
		createMyWindow();

		testingTable();

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
		// frame.add(sentDronesTable);
		// frame.add(receivedDronesTable);

		frame.add(sentDronesScrollableTable);
		frame.add(receivedDronesScrollableTable);
		frame.add(returnButton);
	}

	public void setLocation()
	{
		// sentDronesTable.setFont(new Font("Serif", Font.PLAIN, 15));
		// sentDronesTable.setBounds((int)(W/10), H/30, (int)(W/1.2), H/4);

		// receivedDronesTable.setFont(new Font("Serif", Font.PLAIN, 15));
		// receivedDronesTable.setBounds((int)(W/10), H/30 + H/4, (int)(W/1.2), H/4);

		sentDronesScrollableTable.setBounds((int)(W/10), H/30, (int)(W - (2 * (W/10))), H/4);
    	sentDronesScrollableTable.setVisible(true);

		receivedDronesScrollableTable.setBounds((int)(W/10), H/30 + H/4 + 20, (int)(W - (2 * (W/10))), H/4);
    	receivedDronesScrollableTable.setVisible(true);


		returnButton.setFont(new Font("Serif", Font.BOLD, 30));
		returnButton.setBounds(W/4, (int)(H/1.2) , W/2, H/15);
	}


	public void actionEventFunc()
	{
		returnButton.addActionListener(this);
	}





	
	public void testingTable() {
		
		String[] headers = { "Date", "From", "To" };

		ArrayList<String> dateList = new ArrayList<>();
		ArrayList<String> fromList = new ArrayList<>();
		ArrayList<String> toList = new ArrayList<>();

		DronePostDB db = new DronePostDB();
		db.getOrderSent(dateList, fromList, toList);

		String[][] tableData = new String[fromList.size()][3];

		for(int i = 0; i < fromList.size(); ++i) {
			tableData[i][0] = dateList.get(i);
			tableData[i][1] = fromList.get(i);
			tableData[i][2] = toList.get(i);
		}

		// for(int i = 0; i < fromList.size(); ++i) {
		// 	tableData[fromList.size() + i][0] = dateList.get(i);
		// 	tableData[fromList.size() + i][1] = fromList.get(i);
		// 	tableData[fromList.size() + i][2] = toList.get(i);
		// }

		sentDronesTable = new JTable(tableData, headers);
		receivedDronesTable = new JTable(tableData, headers);

		sentDronesScrollableTable = new JScrollPane(sentDronesTable);
		receivedDronesScrollableTable = new JScrollPane(receivedDronesTable);

		
	}
	
	// archive
	{
	// public void testingTable() {
		
	// 	String[] headers = { "From", "To", "3"};
	// 	// String[][] tableData = {{ "ludo", "shali"},{ "oz", "shali"}};
	// 	// String[][] tableData = {{ "empty", "empty"},{ "empty", "empty"}};

	// 	ArrayList<String> fromList = new ArrayList<>();
	// 	ArrayList<String> toList = new ArrayList<>();
	// 	DronePostDB db = new DronePostDB();
	// 	db.getOrderSent(fromList, toList);
		
	// 	// String[] arrFrom = (String[])fromList.toArray();
	// 	// String[] arrTo = (String[])toList.toArray();

	// 	// String[][] tableData = {arrFrom, arrTo};
	// 	// String[][] tableData = {arrFrom, arrTo};
		
	// 	// String[] f = {"a", "b", "c"};
	// 	// String[] t = {"1", "2", "3"};
	// 	// String[][] tableData = {f, t};
	// 	String[][] tableData = {{"a", "b", "c"}, {"1", "2", "3"}};
		
	// 	// String[][] tableData = {{ (String[])fromList.toArray() }, {toList }};
	// 	// String[][] tableData = {{ fromList.get(0), toList.get(0) },
	// 							// {fromList.get(1), toList.get(1)} };							
	// 	// {"empty", "empty" } };

	// 	// tableData[0] = rowData;

	// 	sentDronesTable = new JTable(tableData, headers);
	// 	// sentDronesTable = new JTable(tableData, headers);

		
	// }
	}










	@Override
	public void actionPerformed(ActionEvent e) {
		boolean validDst = true;
		if(e.getSource() == returnButton) {
			frame.dispose();
			new WelcomeWindow();
		}
	}


}