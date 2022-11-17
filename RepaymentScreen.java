import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RepaymentScreen {

	private JFrame frame;
	private JTextField textAmount;
	
	private int ID;
	private String LoanID;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	LoginModel model = new LoginModel();

	/**
	 * Launch the application.
	 */
	public void run(int id) {
		try {
			RepaymentScreen window = new RepaymentScreen(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public RepaymentScreen(int id) {
		this.ID = id;
		initialize();
		conn = DatabaseConnection.ConnectMySQLDb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		try {
			String sql = "SELECT * FROM mwanzobaraka.membloanapplication WHERE MemberId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ID);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				LoanID = rs.getString("LoanId");
				System.out.println(LoanID);
			}
			
		}catch(Exception loanSelection) {
			loanSelection.printStackTrace();
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 451, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPAYMENT SCREEN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(54, 11, 282, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(31, 140, 104, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(145, 138, 181, 29);
		frame.getContentPane().add(textAmount);
		
		JButton btnRepay = new JButton("REPAY");
		btnRepay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRepay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnRepay.setBackground(new Color(135, 206, 235));
		btnRepay.setBounds(10, 218, 118, 29);
		frame.getContentPane().add(btnRepay);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserNavScreen nav = new UserNavScreen(ID);
				nav.run(ID);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setBounds(267, 218, 96, 29);
		frame.getContentPane().add(btnBack);
	}

}
