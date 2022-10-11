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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen {

	private JFrame frame;
	private JTextField email;
	Connection connection;
	
	LoginModel loginModel = new LoginModel();
	private JPasswordField password;

	/**
	 * Launch the application.
	 */

	
	private void detail(String UserName,String UserContact,String UserEmail,String UserRegDate ) throws SQLException {		
		JFrame detailFrame = new JFrame();
		detailFrame.getContentPane().setBackground(new Color(176, 224, 230));
		detailFrame.setBounds(100, 100, 684, 452);
		detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		detailFrame.getContentPane().setLayout(null);
		
		JLabel lblDetail = new JLabel("DETAILS SCREEN");
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetail.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblDetail.setBounds(198, 11, 280, 51);
		detailFrame.getContentPane().add(lblDetail);
		
		
		JLabel lblNameHeader = new JLabel("Name :");
		lblNameHeader.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNameHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameHeader.setBounds(80, 98, 65, 20);
		detailFrame.getContentPane().add(lblNameHeader);
		
		JLabel lblUsername = new JLabel(UserName);
//		System.out.println(lblUsername.getText());
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(155, 98, 120, 18);
		detailFrame.getContentPane().add(lblUsername);
		
		JLabel lblContactHeader = new JLabel("Contact :");
		lblContactHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactHeader.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactHeader.setBounds(76, 139, 65, 20);
		detailFrame.getContentPane().add(lblContactHeader);
		
		JLabel lblEmailHeader = new JLabel("Email :");
		lblEmailHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailHeader.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmailHeader.setBounds(76, 184, 65, 20);
		detailFrame.getContentPane().add(lblEmailHeader);
		
		JLabel lblDateOfRegistration = new JLabel("Date of Registration : ");
		lblDateOfRegistration.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfRegistration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateOfRegistration.setBounds(10, 228, 131, 20);
		detailFrame.getContentPane().add(lblDateOfRegistration);
		
		JLabel lblUserContact = new JLabel(UserContact);
		lblUserContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserContact.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUserContact.setBounds(155, 143, 120, 18);
		detailFrame.getContentPane().add(lblUserContact);
		
		JLabel lblUserEmail = new JLabel(UserEmail);
		lblUserEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserEmail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUserEmail.setBounds(155, 184, 120, 18);
		detailFrame.getContentPane().add(lblUserEmail);
		
		JLabel lblUserReg = new JLabel(UserRegDate);
		lblUserReg.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserReg.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUserReg.setBounds(155, 228, 120, 18);
		detailFrame.getContentPane().add(lblUserReg);
		
		JButton btnLoan = new JButton("LOANS");
		btnLoan.setBackground(new Color(147, 112, 219));
		btnLoan.setFont(new Font("Century", Font.PLAIN, 14));
		btnLoan.setBounds(456, 96, 89, 23);
		detailFrame.getContentPane().add(btnLoan);
		
		JButton btnContribution = new JButton("CONTRIBUTE");
		btnContribution.setFont(new Font("Century", Font.PLAIN, 14));
		btnContribution.setBackground(new Color(147, 112, 219));
		btnContribution.setBounds(456, 179, 131, 23);
		detailFrame.getContentPane().add(btnContribution);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame quitFrame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(quitFrame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Century", Font.BOLD, 14));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(569, 344, 89, 23);
		detailFrame.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				detailFrame.dispose();
			}
		});
		btnLogout.setFont(new Font("Century", Font.BOLD, 14));
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(10, 344, 106, 23);
		detailFrame.getContentPane().add(btnLogout);
	}

	
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
						
//						try {
//							connection = SqliteConnection.ConnectDb();			
//						}catch(Exception err) {
//							err.printStackTrace();
//						}
//						
//						PreparedStatement pr = null;
//						ResultSet rs = null;
//						
//						String sql = "SELECT * FROM Member where Email = ? and Password = ?";
//							pr = connection.prepareStatement(sql);
//							pr.setString(1, email.getText());
//							pr.setString(2, password.getText());
//							
//							rs = pr.executeQuery();
							
//							if(rs.next()) {
////								UserName,UserContact,UserEmail,UserRegDate;
//								String UserName = rs.getString("FirstName") + " " + rs.getString("LastName");
////								lblUsername.setText(rs.getString("FirstName") + " " + rs.getString("LastName"));
//								String UserContact = rs.getString("Contact");
////								lblUserContact.setText(rs.getString("Contact"));
//								String UserEmail = rs.getString("Email");
////								lblUserEmail.setText(rs.getString("Email"));
//								String UserRegDate = rs.getString("RegDate");
////								lblUserReg.setText(rs.getString("RegDate"));
//								
////								detail(UserName, UserEmail, UserContact, UserRegDate);
//								DetailScreen detail = new DetailScreen(UserName, UserEmail, UserContact, UserRegDate);							
//								detail.lblUserContact.setText(UserContact);
//								detail.lblUsername.setText(UserName);
//								detail.lblUserEmail.setText(UserEmail);
//								detail.lblUserReg.setText(UserRegDate);
//								detail.run();
//								detail.userDetails(email.getText(), password.getText());
//								frame.dispose();
//							}
							UserNavScreen navScreen = new UserNavScreen();
							navScreen.run();
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
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(194, 191, 168, 27);
		frame.getContentPane().add(password);
	}
}
