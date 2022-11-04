import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GrpMemberReg {

	private JFrame frame;
	private JTextField textEmail;
	private JTextField textFullName;
	private JTextField textID;
	
	String GroupName;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;



	/**
	 * Launch the application.
	 */
	public void run(String grpName) {
		try {
			GrpMemberReg window = new GrpMemberReg(grpName);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public GrpMemberReg(String grpName) {
		conn = SqliteConnection.ConnectMySQLDb();
		this.GroupName = grpName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		System.out.println(GroupName);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 527, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblEmail.setBounds(31, 237, 132, 36);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBounds(173, 237, 226, 36);
		frame.getContentPane().add(textEmail);
		
		JLabel lblNewLabel = new JLabel("GROUP MEMBER ADDITION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(31, 11, 401, 54);
		frame.getContentPane().add(lblNewLabel);
		
		textFullName = new JTextField();
		textFullName.setHorizontalAlignment(SwingConstants.CENTER);
		textFullName.setColumns(10);
		textFullName.setBounds(173, 170, 226, 36);
		frame.getContentPane().add(textFullName);
		
		JLabel lblFullName = new JLabel("Full Name: ");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblFullName.setBounds(31, 170, 132, 36);
		frame.getContentPane().add(lblFullName);
		
		JLabel lblIdNumber = new JLabel("ID Number : ");
		lblIdNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdNumber.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblIdNumber.setBounds(31, 102, 132, 36);
		frame.getContentPane().add(lblIdNumber);
		
		textID = new JTextField();
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setColumns(10);
		textID.setBounds(173, 102, 226, 36);
		frame.getContentPane().add(textID);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String sqlStatement = "INSERT INTO GrpUsers VALUES(?,?,?,?)";
				String sqlStatement = "INSERT INTO grpusers VALUES(?,?,?,?)";
				try {
					pst = conn.prepareStatement(sqlStatement);
					pst.setInt(1, Integer.parseInt(textID.getText()));
					pst.setString(2, textFullName.getText());
					pst.setString(3, textEmail.getText());
					pst.setString(4, GroupName);
					
					pst.execute();
					
					pst.close();
					conn.close();
					frame.dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "System update experienced "+ e2);
					System.out.println(e2);
				}
			}
		});
		btnAdd.setBackground(new Color(135, 206, 235));
		btnAdd.setBounds(31, 336, 89, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupRegScreen grp = new GroupRegScreen();
				grp.run();
				
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setBounds(381, 336, 89, 29);
		frame.getContentPane().add(btnBack);
	}
}
