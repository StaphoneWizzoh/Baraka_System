import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 607, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBarakaSystem = new JLabel("BARAKA SYSTEM");
		lblBarakaSystem.setFont(new Font("Cambria", Font.BOLD, 48));
		lblBarakaSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarakaSystem.setBounds(10, 43, 661, 86);
		frame.getContentPane().add(lblBarakaSystem);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen login = new LoginScreen();
				login.run();
				frame.dispose();
				
			}
		});
		btnLogin.setBackground(new Color(175, 238, 238));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnLogin.setBounds(55, 153, 163, 50);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationScreen reg = new RegistrationScreen();
				reg.run();
				frame.dispose();
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		btnRegister.setBackground(new Color(173, 255, 47));
		btnRegister.setBounds(55, 280, 171, 50);
		frame.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(381, 221, 115, 44);
		frame.getContentPane().add(btnExit);
	}
}
