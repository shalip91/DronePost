package drone_package;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//1
public class WelcomeWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JLabel titleLabel = new JLabel("Welcome to DronePost");
	private JLabel nameLabel = new JLabel("Enter Name: ");
	private JTextField signInTextField = new JTextField();
	private JButton signInButton = new JButton("Sign In");
	private JButton registerButton = new JButton("Register");
	private int H = 600;
	private int W = 500;
	
	public WelcomeWindow() {
		createMyWindow();
		setLocation();
		addComponents();
		actionEventFunc();
	}
	public void createMyWindow()
	{
		frame=new JFrame();
		frame.setTitle("Welcome Window");
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
//		frame.add(nameLabel);
	}
	
	public void setLocation()
	{
		
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		Dimension size = titleLabel.getMaximumSize();
		titleLabel.setBounds(40, 21, size.width, size.height);

		
//		nameLabel.setFont(new Font("Serif", Font.BOLD, 30));
//		nameLabel.setBounds(W/10,H/15, 200, 1);
		
//		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
//		titleLabel.setBounds(W/5,H/20, 400, 40);
//		
//		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
//		titleLabel.setBounds(W/5,H/20, 400, 40);
//		
//		titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
//		titleLabel.setBounds(W/5,H/20, 400, 40);

	}
	

	public void actionEventFunc()
	{
//		getDetailsButton.addActionListener(this);
//		putDetailsButton.addActionListener(this);
//		nextButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == getDetailsButton) {
//			String args[] = argsText.getText().split(",");
//			personGenerator.getDetails(args);
//			argsText.setText("");
//			fileNameText.setText("");
//		}
//		if(e.getSource() == putDetailsButton) {
//			String name = fileNameText.getText();
//			personFileName = name;
//			personGenerator.putDetails(name);
//			argsText.setText("");
//			fileNameText.setText("");
//		}
//		if(e.getSource() == nextButton) {
//			frame.dispose();
//			new PersonTableForm(personFileName);
//		}

	}
	
	
}
