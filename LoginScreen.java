import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	
	LoginModel loginModel = new LoginModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 558, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbLLogin = new JLabel("LOGIN SCREEN");
		lbLLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbLLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbLLogin.setBounds(166, 29, 253, 45);
		frame.getContentPane().add(lbLLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(new Color(175, 238, 238));
		lblUsername.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(52, 109, 132, 30);
		frame.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(194, 110, 168, 30);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblPassword.setBackground(new Color(175, 238, 238));
		lblPassword.setBounds(52, 188, 132, 30);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setColumns(10);
		password.setBounds(194, 189, 168, 30);
		frame.getContentPane().add(password);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(loginModel.isLoggedIn(username.getText(), password.getText())) {
						JOptionPane.showMessageDialog(null,"You are logged in");
					}else {
						JOptionPane.showMessageDialog(lbLLogin, "Your credentials are incorrect");
					}
					
				}catch(Exception error) {
					
				}
			}
		});
		btnLogin.setBackground(new Color(135, 206, 235));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBounds(216, 288, 123, 30);
		frame.getContentPane().add(btnLogin);
	}
}
