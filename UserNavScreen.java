import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserNavScreen {

	private JFrame frame;
	private int ID;
	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}

	Connection connection;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			UserNavScreen window = new UserNavScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public UserNavScreen() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		System.out.println(	getID());
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 583, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAVIGATION SCREEN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(177, 11, 253, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnDetailView = new JButton("VIEW DETAILS");
		btnDetailView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					connection = SqliteConnection.ConnectDb();
					PreparedStatement pr = null;
					ResultSet rs = null;
					
					String sql = "SELECT * FROM Member where IdNumber=?";
					pr = connection.prepareStatement(sql);
					pr.setInt(1, getID());
					rs = pr.executeQuery();
					
					while(rs.next()) {
						
						DetailScreen details = new DetailScreen();
						

						details.setNAME(rs.getString("FirstName") + " " + rs.getString("LastName"));
						details.setCONTACT(rs.getString("Contact"));
						details.setEMAIL(rs.getString("Email"));
						details.setREGDATE(rs.getString("RegDate"));
						System.out.println(rs.getString("RegDate"));
						details.run();
						
//						UserNavScreen navScreen = new UserNavScreen(UserName, UserEmail, UserContact, UserRegDate);
//						navScreen.run();
//						detail.userDetails(email.getText(), password.getText());
						frame.dispose();
					}
				}catch(Exception err) {
					err.printStackTrace();
				}

				frame.dispose();
					
					
				
			}
		});
		btnDetailView.setBackground(new Color(102, 205, 170));
		btnDetailView.setBounds(10, 84, 155, 23);
		frame.getContentPane().add(btnDetailView);
		
		JButton btnLoanApplication = new JButton("LOAN APPLICATION");
		btnLoanApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationScreen apply = new ApplicationScreen();
				apply.run();
				frame.dispose();
			}
		});
		btnLoanApplication.setBackground(new Color(102, 205, 170));
		btnLoanApplication.setBounds(10, 148, 155, 23);
		frame.getContentPane().add(btnLoanApplication);
		
		JButton btnLoanRepay = new JButton("REPAY LOAN");
		btnLoanRepay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepaymentScreen repay = new RepaymentScreen();
				repay.run();
				frame.dispose();
			}
		});
		btnLoanRepay.setBackground(new Color(102, 205, 170));
		btnLoanRepay.setBounds(420, 148, 137, 23);
		frame.getContentPane().add(btnLoanRepay);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBackground(new Color(220, 20, 60));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBounds(10, 270, 118, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnExit = new JButton("EXIT SYSTEM");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(439, 270, 118, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnContribute = new JButton("CONTRIBUTE");
		btnContribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContributionScreen contr = new ContributionScreen();
				contr.run();
				frame.dispose();
			}
		});
		btnContribute.setBackground(new Color(102, 205, 170));
		btnContribute.setBounds(420, 84, 137, 23);
		frame.getContentPane().add(btnContribute);
		
		JButton btnAdminPage = new JButton("ADMIN PAGE");
		btnAdminPage.setBackground(new Color(64, 224, 208));
		btnAdminPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminNavScreen admScr = new AdminNavScreen();
				admScr.run();
				frame.dispose();
			}
		});
		btnAdminPage.setBounds(227, 270, 118, 23);
		frame.getContentPane().add(btnAdminPage);
	}
}
