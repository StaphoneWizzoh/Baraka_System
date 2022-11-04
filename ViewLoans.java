import java.awt.EventQueue;

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

public class ViewLoans {

	private JFrame frame;
	private JTable table;
	
	private int ID;
	public String NAME;
	Connection connection = SqliteConnection.ConnectMySQLDb();
	PreparedStatement pr = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public void run(int id) {
		try {
			ViewLoans window = new ViewLoans(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ViewLoans(int id) {
		this.ID = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		try {
//			PreparedStatement prep = null;
//			ResultSet rset = null;
//			
//			String sql = "SELECT * FROM Member where IdNumber=?";
//			prep = connection.prepareStatement(sql);
//			prep.setInt(1, this.ID);
//			rset = pr.executeQuery();
//			
//			if(rset.next()) {				
//				NAME = rset.getString("FirstName") + " " + rset.getString("LastName");		
//			}
//			prep.close();
//			rset.close();
//		}catch(Exception err) {
//			err.printStackTrace();
//		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 751, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMwanzoBarakaLoanees = new JLabel("MWANZO BARAKA LOANEES");
		lblMwanzoBarakaLoanees.setHorizontalAlignment(SwingConstants.CENTER);
		lblMwanzoBarakaLoanees.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMwanzoBarakaLoanees.setBounds(196, 11, 322, 42);
		frame.getContentPane().add(lblMwanzoBarakaLoanees);
		
		table = new JTable();
		table.setBounds(34, 110, 662, 353);
		frame.getContentPane().add(table);
		
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
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String sql = "SELECT * FROM MembLoanApplication";
					String sql = "SELECT * FROM membloanapplication";
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
					
					String MemberId,LoanId,Amount,Date;
					String Password = "**confidential**";
					while(rs.next()) {
						LoanId = rs.getString(1);
						MemberId =""+ rs.getInt(2);
						Amount = ""+rs.getDouble(3);
						Date = rs.getString(4);
						String[] row = {LoanId,MemberId,Amount,Date};
						model.addRow(row);
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
		btnGenerate.setBounds(290, 474, 119, 23);
		frame.getContentPane().add(btnGenerate);
		
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
		
		JLabel lblLoanid = new JLabel("LoanId");
		lblLoanid.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoanid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblLoanid.setBounds(71, 83, 83, 14);
		frame.getContentPane().add(lblLoanid);
		
		JLabel lblMemberid = new JLabel("MemberId");
		lblMemberid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMemberid.setBounds(229, 85, 83, 14);
		frame.getContentPane().add(lblMemberid);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAmount.setBounds(406, 85, 83, 14);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDate.setBounds(567, 85, 83, 14);
		frame.getContentPane().add(lblDate);
	}

}
