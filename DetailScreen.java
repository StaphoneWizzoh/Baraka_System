import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DetailScreen {

	public JFrame frame;
	public String NAME,EMAIL,CONTACT,REGDATE;
	
	private int ID;

	/**
	 * Launch the application.
	 */
	
	public void run(int id) {
		try {
			DetailScreen window = new DetailScreen(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public DetailScreen(int id) {
		this.ID = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		try {
			Connection connection = DatabaseConnection.ConnectMySQLDb();
			PreparedStatement pr = null;
			ResultSet rs = null;
			
//			String sql = "SELECT * FROM Member where IdNumber=?";
			String sql = "SELECT * FROM member where IdNumber=?";
			pr = connection.prepareStatement(sql);
			pr.setInt(1, this.ID);
			rs = pr.executeQuery();
			
			if(rs.next()) {				
				NAME = rs.getString("FirstName") + " " + rs.getString("LastName");
				CONTACT = rs.getString("Contact");
				EMAIL = (rs.getString("Email"));
				REGDATE = rs.getString("RegDate");			
			}
			pr.close();
			rs.close();
			connection.close();
		}catch(Exception err) {
			err.printStackTrace();
		}

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 565, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DETAIL SCREEN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 11, 315, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 65, 124, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		Label textUsername = new Label(NAME);
		textUsername.setBounds(140, 66, 213, 22);
		frame.getContentPane().add(textUsername);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBackground(new Color(220, 20, 60));
		btnLogout.setBounds(10, 337, 118, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnExit = new JButton("EXIT SYSTEM");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(421, 337, 118, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblEmail.setBounds(10, 109, 124, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblContact.setBounds(10, 155, 124, 23);
		frame.getContentPane().add(lblContact);
		
		JLabel lblRegDate = new JLabel("Reg. Date");
		lblRegDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegDate.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblRegDate.setBounds(10, 203, 124, 23);
		frame.getContentPane().add(lblRegDate);
		
		Label textEmail = new Label(EMAIL);
		textEmail.setBounds(140, 109, 213, 22);
		frame.getContentPane().add(textEmail);
		
		Label textContact = new Label(CONTACT);
		textContact.setBounds(140, 155, 213, 22);
		frame.getContentPane().add(textContact);
		
		Label textRegDate = new Label(REGDATE);
		textRegDate.setBounds(140, 203, 213, 22);
		frame.getContentPane().add(textRegDate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserNavScreen navScreen = new UserNavScreen(ID);
				navScreen.run(ID);
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(255, 20, 147));
		btnBack.setBounds(220, 337, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}

