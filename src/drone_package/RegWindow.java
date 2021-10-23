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

public class RegWindow extends JFrame implements ActionListener{
	private JFrame frame;
	private JLabel titleLabel = new JLabel("Register new user");
	private JLabel nameLabel = new JLabel("Enter Name: ");
	private JLabel adressLabel = new JLabel("Enter Adress: ");
	private JLabel phoneLabel = new JLabel("Enter Phone: ");
	private JTextField nameTextField = new JTextField();
	private JTextField adressTextField = new JTextField();
	private JTextField phoneTextField = new JTextField();
	
	private JButton registerButton = new JButton("Register new user");
	private int H = 600;
	private int W = 500;
	
	public RegWindow() {
		createMyWindow();
		setLocation();
		addComponents();
		actionEventFunc();
	}
	
	public void addComponents()
	{
		frame.add(titleLabel);
		frame.add(nameLabel);
		frame.add(adressLabel);
		frame.add(phoneLabel);
		frame.add(registerButton);
		frame.add(nameTextField);
		frame.add(adressTextField);
		frame.add(phoneTextField);
	}
	public void createMyWindow()
	{
		frame=new JFrame();
		frame.setTitle("Register Window");
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
	
	
	
	public void setLocation()
	{
		
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		titleLabel.setBounds(W/12, H/30, (int)(W/1.2), H/10);

		nameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		nameLabel.setBounds(W/20, (int)(H/4), (int)(W/2), H/6);
		
		adressLabel.setFont(new Font("Serif", Font.BOLD, 30));
		adressLabel.setBounds(W/20, (int)(H/4) + (int)(H/10), (int)(W/2), H/6);
		
		phoneLabel.setFont(new Font("Serif", Font.BOLD, 30));
		phoneLabel.setBounds(W/20, (int)(H/4) + (int)(H/5), (int)(W/2), H/6);
		
		registerButton.setFont(new Font("Serif", Font.BOLD, 30));
		registerButton.setBounds(W/6, (int)(H/1.5), (int)(W/1.5), H/15);
		
		nameTextField.setBounds(W/20 + (int)(W/2.7) , (int)(H/3.5), (int)(W/2), H/10);
		adressTextField.setBounds(W/20 + (int)(W/2.7), (int)(H/3.5) + (int)(H/9), (int)(W/2), H/10);
		phoneTextField.setBounds(W/20 + (int)(W/2.7), (int)(H/3.5) + (int)(H/4.5), (int)(W/2), H/10);
		

		nameTextField.setFont(new Font("Serif", Font.BOLD, 30));
		adressTextField.setFont(new Font("Serif", Font.BOLD, 30));
		phoneTextField.setFont(new Font("Serif", Font.BOLD, 30));


	}

	public void actionEventFunc()
	{
		registerButton.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource() == registerButton) {
		frame.dispose();
		new WelcomeWindow();
		
	}

	}
	
	
}
