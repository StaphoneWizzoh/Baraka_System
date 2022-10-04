import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DetailScreen {

	private JFrame frame;
	Connection connection;

	String email,password,UserName,UserContact,UserEmail,UserRegDate;
	
	public void run() {
		try {
			DetailScreen window = new DetailScreen(" ", " ");

			userDetails(this.email,this.password);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public DetailScreen(String email,String password) {
		this.email = email;
		this.password = password;
		try {
			this.connection = SqliteConnection.ConnectDb();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (this.connection == null) {
			System.exit(1);
		}
		
		try {
			userDetails(this.email,this.password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}
	
	public void userDetails(String email, String password) throws Exception{
		
		if (connection != null) {
			PreparedStatement pr = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM User where Email = ? and Password = ?";
			try {
				pr = this.connection.prepareStatement(sql);
				pr.setString(1, email);
				pr.setString(2, password);
				
				rs = pr.executeQuery();
				
				if(rs.next()) {
//					UserName,UserContact,UserEmail,UserRegDate;
					UserName = rs.getString("FirstName") + " " + rs.getString("LastName");
					UserContact = rs.getString("Contact");
					UserEmail = rs.getString("Email");
					UserRegDate = rs.getString("RegDate");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				pr.close();
				rs.close();
			}
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("1. " + this.email+" "+this.password);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 684, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDetail = new JLabel("DETAILS SCREEN");
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetail.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblDetail.setBounds(198, 11, 280, 51);
		frame.getContentPane().add(lblDetail);
		
		
		JLabel lblNameHeader = new JLabel("Name :");
		lblNameHeader.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNameHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameHeader.setBounds(80, 98, 65, 20);
		frame.getContentPane().add(lblNameHeader);
		
		JLabel lblUsername = new JLabel(UserName);
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(155, 98, 120, 18);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblContactHeader = new JLabel("Contact :");
		lblContactHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactHeader.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactHeader.setBounds(76, 139, 65, 20);
		frame.getContentPane().add(lblContactHeader);
		
		JLabel lblEmailHeader = new JLabel("Email :");
		lblEmailHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailHeader.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmailHeader.setBounds(76, 184, 65, 20);
		frame.getContentPane().add(lblEmailHeader);
		
		JLabel lblDateOfRegistration = new JLabel("Date of Registration : ");
		lblDateOfRegistration.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfRegistration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateOfRegistration.setBounds(10, 228, 131, 20);
		frame.getContentPane().add(lblDateOfRegistration);
		
		JLabel lblUserContact = new JLabel(UserContact);
		lblUserContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserContact.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUserContact.setBounds(155, 143, 120, 18);
		frame.getContentPane().add(lblUserContact);
		
		JLabel lblUserEmail = new JLabel(UserEmail);
		lblUserEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserEmail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUserEmail.setBounds(155, 184, 120, 18);
		frame.getContentPane().add(lblUserEmail);
		
		JLabel lblUserReg = new JLabel(UserRegDate);
		lblUserReg.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserReg.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblUserReg.setBounds(155, 228, 120, 18);
		frame.getContentPane().add(lblUserReg);
		
		JButton btnLoan = new JButton("LOANS");
		btnLoan.setBackground(new Color(147, 112, 219));
		btnLoan.setFont(new Font("Century", Font.PLAIN, 14));
		btnLoan.setBounds(456, 96, 89, 23);
		frame.getContentPane().add(btnLoan);
		
		JButton btnContribution = new JButton("CONTRIBUTE");
		btnContribution.setFont(new Font("Century", Font.PLAIN, 14));
		btnContribution.setBackground(new Color(147, 112, 219));
		btnContribution.setBounds(456, 179, 131, 23);
		frame.getContentPane().add(btnContribution);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Century", Font.BOLD, 14));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(569, 344, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Century", Font.BOLD, 14));
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(10, 344, 106, 23);
		frame.getContentPane().add(btnLogout);
	}
}
