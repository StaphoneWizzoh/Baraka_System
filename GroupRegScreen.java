import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Choice;

public class GroupRegScreen {

	DefaultListModel<Object> model = new DefaultListModel();
	private JFrame frame;
	private JTextField textGroupName;
	private JTextField textRegFee;
	private JTextField textContact;
	private JPasswordField textPassword;
	private JTextField textEmail;
	private JPasswordField textConfirmPassword;
	public String users[];
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public void updateList() {
		conn = SqliteConnection.ConnectDb();
		if (conn != null) {
			String sql = "SELECT * FROM User";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				while (rs.next()) {

					String fName = rs.getString("FirstName");
					String lName = rs.getString("LastName");
					users[1] = fName + " " + lName;
					System.out.println(users);

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The error is " + e);
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			GroupRegScreen window = new GroupRegScreen();
			window.frame.setVisible(true);
//			updateList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public GroupRegScreen() {
		initialize();
		conn = SqliteConnection.ConnectDb();
		updateList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 974, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW GROUP REGISTRATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(168, 11, 622, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGroupName = new JLabel("Group Name : ");
		lblGroupName.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblGroupName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupName.setBounds(57, 136, 132, 36);
		frame.getContentPane().add(lblGroupName);
		
		textGroupName = new JTextField();
		textGroupName.setHorizontalAlignment(SwingConstants.CENTER);
		textGroupName.setBounds(199, 136, 226, 36);
		frame.getContentPane().add(textGroupName);
		textGroupName.setColumns(10);
		
		JLabel lblMembers = new JLabel("Members : ");
		lblMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembers.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblMembers.setBounds(57, 215, 132, 36);
		frame.getContentPane().add(lblMembers);
		
		JLabel lblRegFee = new JLabel("Reg. Fee : ");
		lblRegFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegFee.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblRegFee.setBounds(57, 297, 132, 36);
		frame.getContentPane().add(lblRegFee);
		
		textRegFee = new JTextField();
		textRegFee.setHorizontalAlignment(SwingConstants.CENTER);
		textRegFee.setColumns(10);
		textRegFee.setBounds(199, 297, 226, 36);
		frame.getContentPane().add(textRegFee);
		
		JLabel lblContact = new JLabel("Contact : ");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblContact.setBounds(57, 373, 132, 36);
		frame.getContentPane().add(lblContact);
		
		textContact = new JTextField();
		textContact.setHorizontalAlignment(SwingConstants.CENTER);
		textContact.setColumns(10);
		textContact.setBounds(199, 373, 226, 36);
		frame.getContentPane().add(textContact);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblEmail.setBounds(542, 136, 132, 36);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblPassword.setBounds(542, 215, 132, 36);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password : ");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblConfirmPassword.setBounds(504, 297, 170, 36);
		frame.getContentPane().add(lblConfirmPassword);
		
		textPassword = new JPasswordField();
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textPassword.setBounds(684, 217, 226, 36);
		frame.getContentPane().add(textPassword);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBounds(684, 136, 226, 36);
		frame.getContentPane().add(textEmail);
		
		textConfirmPassword = new JPasswordField();
		textConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textConfirmPassword.setBounds(684, 297, 226, 36);
		frame.getContentPane().add(textConfirmPassword);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBackground(new Color(135, 206, 235));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		    	LocalDateTime now = LocalDateTime.now();
		    	String RegDate = dtf.format(now);
				
				String[] data = new String[7];
				data[0] = textGroupName.getText();
				data[1] = RegDate;
				data[2] = "";
				data[3] = textRegFee.getText();
				data[4] = textEmail.getText();
				data[5] = textPassword.getText();
				data[6]  = textContact.getText();
				
				String sqlInsert = "INSERT INTO Group (Name, RegDate, Members, RegFee, Email, Password, Contact)VALUES(?,?,?,?,?,?,?)";
				try {
					pst = conn.prepareStatement(sqlInsert);
					pst.setString(1, textGroupName.getText());
					pst.setString(2, RegDate);
					pst.setString(3, "");
					pst.setInt(4, Integer.parseInt(textRegFee.getText()));
					pst.setString(5, textEmail.getText());
					pst.setString(6,  textPassword.getText());
					pst.setString(7, textContact.getText());
					
					pst.execute();
					
					LoginScreen login = new LoginScreen();
					login.run();
					
					rs.close();
					pst.close();
					frame.dispose();  
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, "System update experienced "+ err);
					System.out.println(err);
				}
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBounds(57, 483, 147, 34);
		frame.getContentPane().add(btnRegister);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationScreen reg = new RegistrationScreen();
				reg.run();
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(684, 483, 147, 34);
		frame.getContentPane().add(btnBack);
		
		Choice choiceMembers = new Choice();

		
		choiceMembers.setBounds(202, 231, 223, 36);
		frame.getContentPane().add(choiceMembers);
	}
}
