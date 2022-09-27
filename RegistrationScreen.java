import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationScreen {

	private JFrame frame;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textContact;
	private JTextField textPassword;
	private JTextField textPasswordconfirm;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	
	public void updateTable() {
		conn = SqliteConnection.ConnectDb();
		if (conn != null) {
			String sql = "Select ID, FirstName, LastName, Email, Contact from User";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[5];
				
				while (rs.next()) {
					columnData[0] = rs.getString("ID");
					columnData[1] = rs.getString("FirstName");
					columnData[2] = rs.getString("LastName");
					columnData[3] = rs.getString("Email");
					columnData[4] = rs.getString("Contact");
					model.addRow(columnData);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationScreen window = new RegistrationScreen();
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
	public RegistrationScreen() {
		initialize();
		conn = SqliteConnection.ConnectDb();
		
		Object column[] = {"ID", "FirstName", "LastName", "Email", "Contact"};
		model.setColumnIdentifiers(column);
//		table.setModel(model);
		
		updateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 1123, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("NEW MEMBER REGISTRATION");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblRegistration.setBounds(213, 11, 660, 89);
		frame.getContentPane().add(lblRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(42, 138, 164, 36);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblLastName.setBounds(42, 202, 164, 36);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblContact.setBounds(42, 272, 164, 36);
		frame.getContentPane().add(lblContact);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblPassword.setBounds(579, 138, 164, 36);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblConfirmPassword.setBounds(579, 202, 210, 36);
		frame.getContentPane().add(lblConfirmPassword);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = new String[5];
				data[0] = textFirstName.getText();
				data[1] = textLastName.getText();
				data[2] = textContact.getText();
				data[3] = textPassword.getText();
				data[4] = textPasswordconfirm.getText();
				
				String sqlInsert = "INSERT INTO User (ID, FirstName, LastName, Email, Contact)VALUES(?,?,?,?,?)";
				try {
					pst = conn.prepareStatement(sqlInsert);
					pst.setInt(1, 2);
					pst.setString(2, textFirstName.getText());
					pst.setString(3, textLastName.getText());
					pst.setString(4, textContact.getText());
					pst.setString(5, textPassword.getText());
					pst.setString(5, textPasswordconfirm.getText());
					
					pst.execute();
					
					//JOptionPane.showMessageDialog(null, "System update Completed");
					
					rs.close();
					pst.close();
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, "System update experienced "+ err);
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSubmit.setBackground(new Color(135, 206, 235));
		btnSubmit.setBounds(60, 454, 146, 36);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setBounds(397, 454, 129, 36);
		frame.getContentPane().add(btnBack);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(213, 138, 193, 36);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(213, 202, 193, 36);
		frame.getContentPane().add(textLastName);
		
		textContact = new JTextField();
		textContact.setColumns(10);
		textContact.setBounds(213, 272, 193, 36);
		frame.getContentPane().add(textContact);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(816, 138, 193, 36);
		frame.getContentPane().add(textPassword);
		
		textPasswordconfirm = new JTextField();
		textPasswordconfirm.setColumns(10);
		textPasswordconfirm.setBounds(816, 202, 193, 36);
		frame.getContentPane().add(textPasswordconfirm);
		
		JButton btnGroupRegistration = new JButton("GROUP REGISTRATION");
		btnGroupRegistration.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnGroupRegistration.setBackground(new Color(127, 255, 212));
		btnGroupRegistration.setBounds(667, 454, 342, 36);
		frame.getContentPane().add(btnGroupRegistration);
	}

}
