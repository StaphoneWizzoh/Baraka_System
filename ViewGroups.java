import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewGroups {

	private JFrame frame;
	private JTable table;
	
	private int ID;
	Connection connection = SqliteConnection.ConnectMySQLDb();
	PreparedStatement pr = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public void run(int id) {
		try {
			ViewGroups window = new ViewGroups(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ViewGroups(int id) {
		this.ID = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 750, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MWANZO BARAKA GROUPS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(204, 11, 322, 42);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(34, 107, 662, 353);
		frame.getContentPane().add(table);
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String sql = "SELECT * from Groups";
					String sql = "SELECT * FROM mwanzobaraka.groups";
					Statement st = connection.createStatement();
					rs = st.executeQuery(sql);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
//					ResultSetMetaData rsmd = rs.getMetaData();
//					int cols = rsmd.getColumnCount();
//					String[] colName = new String[cols];
//					for(int i=0;i<cols;i++) {
//						colName[i] = rsmd.getColumnName(i+1);
//					}
//					model.setColumnIdentifiers(colName);
					
					String Name,RegDate,Email,Contact;
					double RegFee;
					String Password = "**confidential**";
					if(rs.next()) {
						while(rs.next()) {
							Name = rs.getString(1);
							RegDate = rs.getString(2);
							RegFee = rs.getDouble(3);
							Email = rs.getString(4);
							Contact = rs.getString(6);
							String[] row = {Name,RegDate,""+RegFee,Email,Password,Contact};
							model.addRow(row);
						}
					}else {
						JOptionPane.showMessageDialog(null,"There are currently no active groups in the organisation");
					}
					
					st.close();
					rs.close();
					connection.close();
					
			}catch(Exception er) {
					JOptionPane.showMessageDialog(null,"Fetching experienced the following :" + e);
			}
			}
		});
		btnGenerate.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 11));
		btnGenerate.setBackground(new Color(135, 206, 250));
		btnGenerate.setBounds(293, 471, 119, 23);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminNavScreen adm = new AdminNavScreen(ID);
				adm.run(ID);
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setBounds(10, 474, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnQuitSystem = new JButton("QUIT SYSTEM");
		btnQuitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnQuitSystem.setBackground(new Color(199, 21, 133));
		btnQuitSystem.setBounds(566, 474, 160, 23);
		frame.getContentPane().add(btnQuitSystem);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblName.setBounds(46, 83, 83, 23);
		frame.getContentPane().add(lblName);
		
		JLabel lblRegdate = new JLabel("RegDate");
		lblRegdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRegdate.setBounds(154, 83, 83, 23);
		frame.getContentPane().add(lblRegdate);
		
		JLabel lblRegfee = new JLabel("RegFee");
		lblRegfee.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegfee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRegfee.setBounds(260, 83, 83, 23);
		frame.getContentPane().add(lblRegfee);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblEmail.setBounds(367, 83, 83, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPassword.setBounds(473, 83, 83, 23);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblContact.setBounds(573, 83, 83, 23);
		frame.getContentPane().add(lblContact);
	}
}
