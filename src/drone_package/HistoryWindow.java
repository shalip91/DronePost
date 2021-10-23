package drone_package;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.Math;

public class HistoryWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JTable myTable = new JTable();

	private JButton returnButton = new JButton("Return");
	private int H = 600;
	private int W = 500;
	private String userName;

	public HistoryWindow() {
		createMyWindow();
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
		frame.add(myTable);
		frame.add(returnButton);
	}

	public void setLocation()
	{

		myTable.setFont(new Font("Serif", Font.BOLD, 40));
		myTable.setBounds((int)(W/10), H/30, (int)(W/1.2), H/4);


		returnButton.setFont(new Font("Serif", Font.BOLD, 30));
		returnButton.setBounds(W/4, (int)(H/1.2) , W/2, H/15);
	}


	public void actionEventFunc()
	{
		returnButton.addActionListener(this);
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