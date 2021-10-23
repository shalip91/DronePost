package drone_package;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomeWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JLabel titleLabel = new JLabel("Welcome to DronePost");
	private JLabel nameLabel = new JLabel("Enter Name: ");
	private JTextField signInTextField = new JTextField();
	private JButton signInButton = new JButton("Sign In");
	private JButton registerButton = new JButton("Register");
	
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
		frame.setBounds(30,30,600,400);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(
				         dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(240,250,243));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void setLocation()
	{
		
		titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
		titleLabel.setBounds(20,20,400,23);

	}
	
	public void addComponents()
	{
		frame.add(titleLabel);
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
