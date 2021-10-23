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
		frame.add(nameLabel);
		frame.add(signInTextField);
		frame.add(signInButton);
		frame.add(registerButton);
	}
	
	public void setLocation()
	{
		
		titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
		titleLabel.setBounds(W/12, H/30, (int)(W/1.2), H/10);

		nameLabel.setFont(new Font("Serif", Font.BOLD, 30));
		nameLabel.setBounds(W/20, (int)(H/3.5), (int)(W/2), H/6);
		
		signInTextField.setFont(new Font("Serif", Font.BOLD, 30));
		signInTextField.setBounds((int)(W/2.3),H/3, W/2 , H/12);
		
		signInButton.setFont(new Font("Serif", Font.BOLD, 30));
		signInButton.setBounds(W/3, H/2, W/3, H/15);
		
		registerButton.setFont(new Font("Serif", Font.BOLD, 30));
		registerButton.setBounds(W/3, H/2 + H/10, W/3, H/15);

	}
	

	public void actionEventFunc()
	{
		signInButton.addActionListener(this);
		registerButton.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signInButton) {
			String userName = signInTextField.getText();
			// TODO: verify against the data base
			boolean validName = true;
			if (validName) {
				frame.dispose();
				new InnerAppWindow(userName);
			}
			else {
				JOptionPane.showMessageDialog(frame, "Please enter valid user name");
			}
		}
			
			
			
		
		if(e.getSource() == registerButton) {
		frame.dispose();
		new RegWindow();
		
	}

	}
	
	
}
