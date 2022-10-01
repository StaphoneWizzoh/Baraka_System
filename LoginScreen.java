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
import javax.swing.JPasswordField;

public class LoginScreen {

	private JFrame frame;
	private JTextField email;
	
	LoginModel loginModel = new LoginModel();
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			
//		});
//	}
	
	public void run() {
		try {
			LoginScreen window = new LoginScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBackground(new Color(175, 238, 238));
		lblEmail.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(52, 109, 132, 30);
		frame.getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(194, 110, 168, 30);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblPassword.setBackground(new Color(175, 238, 238));
		lblPassword.setBounds(52, 188, 132, 30);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(loginModel.isLoggedIn(email.getText(), password.getText())) {
						DetailScreen detail = new DetailScreen();
						detail.run();
						frame.dispose();
					}else {
						JOptionPane.showMessageDialog(lbLLogin, "Your credentials are incorrect");
					}
					
				}catch(Exception error) {
					error.printStackTrace();
				}
			}
		});
		btnLogin.setBackground(new Color(135, 206, 235));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBounds(52, 293, 123, 30);
		frame.getContentPane().add(btnLogin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBackground(new Color(135, 206, 235));
		btnBack.setBounds(362, 293, 123, 30);
		frame.getContentPane().add(btnBack);
		
		password = new JPasswordField();
		password.setBounds(194, 191, 168, 27);
		frame.getContentPane().add(password);
	}
}
