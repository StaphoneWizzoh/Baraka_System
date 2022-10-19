import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ViewMembers {

	private JFrame frame;
	
	Connection connection = SqliteConnection.ConnectDb();
	PreparedStatement pr = null;
	ResultSet rs = null;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ViewMembers window = new ViewMembers();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ViewMembers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 752, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setBounds(10, 510, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnQuitSystem = new JButton("QUIT SYSTEM");
		btnQuitSystem.setBackground(new Color(199, 21, 133));
		btnQuitSystem.setBounds(566, 510, 160, 23);
		frame.getContentPane().add(btnQuitSystem);
		
		JLabel lblNewLabel = new JLabel("MWANZO BARAKA MEMBERS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(204, 11, 322, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {									
				try {
						String sql = "SELECT * from Member";
						Statement st = connection.createStatement();
						rs = st.executeQuery(sql);
						ResultSetMetaData rsmd = rs.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						int cols = rsmd.getColumnCount();
						String[] colName = new String[cols];
						for(int i=0;i<cols;i++) {
							colName[i] = rsmd.getColumnName(i+1);
						}
						model.setColumnIdentifiers(colName);
						
						String IdNumber,FirstName,LastName,Email,Contact,RegDate,RegFee;
						while(rs.next()) {
							IdNumber = rs.getString(1);
							FirstName = rs.getString(2);
							LastName = rs.getString(3);
							Email = rs.getString(4);
							Contact = rs.getString(5);
							RegDate = rs.getString(6);
							RegFee = rs.getString(7);
							String[] row = {IdNumber,FirstName,LastName,Email,Contact,RegDate,RegFee};
							model.addRow(row);
						}
						st.close();
						rs.close();
						
						
				}catch(Exception er) {
						JOptionPane.showMessageDialog(null,"Fetching experienced the following :" + e);
				}
				
			}
		});
		btnGenerate.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 11));
		btnGenerate.setBackground(new Color(135, 206, 250));
		btnGenerate.setBounds(288, 449, 119, 23);
		frame.getContentPane().add(btnGenerate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 422, 532, -353);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(23, 64, 677, 361);
		frame.getContentPane().add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	}
}
