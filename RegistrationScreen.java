import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationScreen {

	private JFrame frame;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textContact;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textID;
	private JTextField textEmail;
	private JPasswordField textPassword;
	private JTextField textRegFee;

	/**
	 * Launch the application.
	 */
	
	public void run() {
		try {
			RegistrationScreen window = new RegistrationScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public RegistrationScreen() {
		initialize();
		conn = DatabaseConnection.ConnectMySQLDb();
		
		Object column[] = {"IdNumber", "FirstName", "LastName", "Email", "Contact","Password", "RegDate", "RegFee"};
		model.setColumnIdentifiers(column);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 993, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("NEW MEMBER REGISTRATION");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblRegistration.setBounds(127, 11, 660, 71);
		frame.getContentPane().add(lblRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(44, 93, 164, 36);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblLastName.setBounds(44, 157, 164, 36);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblContact.setBounds(44, 286, 164, 36);
		frame.getContentPane().add(lblContact);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblPassword.setBounds(492, 157, 164, 36);
		frame.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		    	LocalDateTime now = LocalDateTime.now();
		    	String RegDate = dtf.format(now);				
				
//				String sqlInsert = "INSERT INTO Member (IdNumber, FirstName, LastName, Email, Contact, Password, RegDate, RegFee)VALUES(?,?,?,?,?,?,?,?)";
		    	String sqlInsert = "INSERT INTO member (IdNumber, FirstName, LastName, Email, Contact, Password, RegDate, RegFee)VALUES(?,?,?,?,?,?,?,?)";
		    	try {
					pst = conn.prepareStatement(sqlInsert);
					pst.setInt(1, Integer.parseInt(textID.getText()));
					pst.setString(2, textFirstName.getText());
					pst.setString(3, textLastName.getText());
					pst.setString(4, textEmail.getText());
					pst.setString(5, textContact.getText());
					pst.setString(6,  textPassword.getText());
					pst.setString(7, RegDate);
					pst.setInt(8, Integer.parseInt(textRegFee.getText()));
					
					pst.execute();
					
					LoginScreen login = new LoginScreen();
					login.run();
					
					pst.close();
					conn.close();
					frame.dispose();  
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, "System update experienced "+ err);
					System.out.println(err);
				}
				
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBackground(new Color(135, 206, 235));
		btnRegister.setBounds(62, 477, 146, 36);
		frame.getContentPane().add(btnRegister);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(346, 477, 129, 36);
		frame.getContentPane().add(btnBack);
		
		textFirstName = new JTextField();
		textFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		textFirstName.setBounds(215, 93, 193, 36);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setHorizontalAlignment(SwingConstants.CENTER);
		textLastName.setColumns(10);
		textLastName.setBounds(215, 157, 193, 36);
		frame.getContentPane().add(textLastName);
		
		textContact = new JTextField();
		textContact.setHorizontalAlignment(SwingConstants.CENTER);
		textContact.setToolTipText("Optional");
		textContact.setColumns(10);
		textContact.setBounds(215, 286, 193, 36);
		frame.getContentPane().add(textContact);
		
		JButton btnGroupRegistration = new JButton("GROUP REGISTRATION");
		btnGroupRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupRegScreen group = new GroupRegScreen();
				group.run();
				frame.dispose();
			}
		});
		btnGroupRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGroupRegistration.setBackground(new Color(127, 255, 212));
		btnGroupRegistration.setBounds(580, 477, 342, 36);
		frame.getContentPane().add(btnGroupRegistration);
		
		JLabel lblIDNumber = new JLabel("ID Number");
		lblIDNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDNumber.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblIDNumber.setBounds(44, 221, 164, 36);
		frame.getContentPane().add(lblIDNumber);
		
		textID = new JTextField();
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setToolTipText("");
		textID.setColumns(10);
		textID.setBounds(215, 221, 193, 36);
		frame.getContentPane().add(textID);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblEmail.setBounds(492, 93, 164, 36);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBounds(729, 93, 193, 36);
		frame.getContentPane().add(textEmail);
		
		textPassword = new JPasswordField();
		textPassword.setToolTipText("Enter a password to be used in the system utilization.");
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textPassword.setBounds(729, 157, 193, 36);
		frame.getContentPane().add(textPassword);
		
		JLabel lblRegFee = new JLabel("Reg. Fee");
		lblRegFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegFee.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblRegFee.setBounds(44, 353, 164, 36);
		frame.getContentPane().add(lblRegFee);
		
		textRegFee = new JTextField();
		textRegFee.setHorizontalAlignment(SwingConstants.CENTER);
		textRegFee.setToolTipText("Must be KSH. 5000");
		textRegFee.setColumns(10);
		textRegFee.setBounds(215, 353, 193, 36);
		frame.getContentPane().add(textRegFee);
	}
}
