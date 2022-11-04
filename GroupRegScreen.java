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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JScrollPane;

public class GroupRegScreen {

	DefaultListModel<Object> model = new DefaultListModel<Object>();
	private JFrame frame;
	private JTextField textGroupName;
	private JTextField textRegFee;
	private JTextField textContact;
	private JPasswordField textPassword;
	private JTextField textEmail;
	private JList list = new JList();
	
		
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private String GroupName;	
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}

	public void updateList() {
		conn = SqliteConnection.ConnectMySQLDb();
		ArrayList<String> members = new ArrayList<String>();
		if (conn != null) {
//			String sql = "SELECT * FROM GrpUsers";
			String sql = "SELECT * FROM grpusers ";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				while (rs.next()) {

					String name = rs.getString("FullName");
					
					members.add(name);
					System.out.println(name);

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
		conn = SqliteConnection.ConnectMySQLDb();
//		updateList();
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
		lblRegFee.setBounds(57, 323, 132, 36);
		frame.getContentPane().add(lblRegFee);
		
		textRegFee = new JTextField();
		textRegFee.setHorizontalAlignment(SwingConstants.CENTER);
		textRegFee.setColumns(10);
		textRegFee.setBounds(199, 323, 226, 36);
		frame.getContentPane().add(textRegFee);
		
		JLabel lblContact = new JLabel("Contact : ");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblContact.setBounds(57, 394, 132, 36);
		frame.getContentPane().add(lblContact);
		
		textContact = new JTextField();
		textContact.setHorizontalAlignment(SwingConstants.CENTER);
		textContact.setColumns(10);
		textContact.setBounds(199, 394, 226, 36);
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
		
		textPassword = new JPasswordField();
		textPassword.setToolTipText("Enter a password to be used in the system utilization.");
		textPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textPassword.setBounds(684, 217, 226, 36);
		frame.getContentPane().add(textPassword);
		
		textEmail = new JTextField();
		textEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textEmail.setColumns(10);
		textEmail.setBounds(684, 136, 226, 36);
		frame.getContentPane().add(textEmail);
		
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
				
				
				try {
//					String sqlInsert = "INSERT INTO Groups VALUES(?,?,?,?,?,?)";
					String sqlInsert = "INSERT INTO mwanzobaraka.groups VALUES(?,?,?,?,?,?)";
					pst = conn.prepareStatement(sqlInsert);
					pst.setString(1, textGroupName.getText());
					pst.setString(2, RegDate);
					pst.setDouble(3, Double.parseDouble(textRegFee.getText()));
					pst.setString(4, textEmail.getText());
					pst.setString(5,  textPassword.getText());
					pst.setString(6, textContact.getText());
					
					pst.executeUpdate();
					
					LoginScreen login = new LoginScreen();
					login.run();
					
					rs.close();
					pst.close();
					frame.dispose();  
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, "System update experienced "+ err);
					System.out.println(err);
				}
				
//				if(list.getSelectedIndex() != -1) {
//					String sqlAdd = "UPDATE GrpUsers SET Group={} WHERE FullName={}".formatted(textGroupName.getText(), list.getSelectedIndex());
//				}
				
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
		
		JButton btnNewMember = new JButton("New Member");
		btnNewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				setGroupName(textGroupName.getText());
				System.out.println("The group name is "+textGroupName.getText());
				
				if(textGroupName.getText()!="") {
					GrpMemberReg mem = new GrpMemberReg(GroupName);
					mem.run(GroupName);
				}else {
					JOptionPane.showMessageDialog(null, "First enter a Group name to add members to it.");
				}
				
			}
		});
		btnNewMember.setBackground(new Color(147, 112, 219));
		btnNewMember.setBounds(199, 278, 115, 23);
		frame.getContentPane().add(btnNewMember);
			
		conn = SqliteConnection.ConnectMySQLDb();
		ArrayList<String> members = new ArrayList<String>();
		DefaultListModel boxModel = new DefaultListModel();
		if (conn != null) {
//			String sql = "SELECT * FROM GrpUsers WHERE GroupName = ?";
			String sql = "SELECT * FROM grpusers WHERE GroupName = ?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, textGroupName.getText());
				rs = pst.executeQuery();				
				while (rs.next()) {
					String name = rs.getString("FullName");			
					members.add(name);
					boxModel.addElement(name);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The error is " + e);
			}
		}
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 215, 226, 36);
		frame.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(list);
		list.setModel(boxModel);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				members.clear();
				boxModel.clear();
				if (conn != null) {
//					String sql = "SELECT * FROM GrpUsers WHERE GroupName = ? ";
					String sql = "SELECT * FROM grpusers WHERE GroupName = ? ";
					try {
						pst = conn.prepareStatement(sql);
						pst.setString(1, textGroupName.getText());
						rs = pst.executeQuery();				
						while (rs.next()) {
							String name = rs.getString("FullName");			
							members.add(name);
							boxModel.addElement(name);
						}
					} catch (Exception er) {
						JOptionPane.showMessageDialog(null, "The error is " + er);
					}
				}
			}
		});
		btnRefresh.setBackground(new Color(0, 255, 0));
		btnRefresh.setBounds(328, 278, 97, 23);
		frame.getContentPane().add(btnRefresh);
	}
}

