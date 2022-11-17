import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ContributionScreen {

	private JFrame frame;
	private JTextField textAmount;
	
	private int ID;
	private Connection conn = null;
	PreparedStatement pst = null;

	/**
	 * Launch the application.
	 */
	public void run(int id) {
		try {
			ContributionScreen window = new ContributionScreen(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ContributionScreen(int id) {
		this.ID = id;
		this.conn = DatabaseConnection.ConnectMySQLDb();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 403, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTRIBUTION SCREEN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(80, 11, 251, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(43, 107, 104, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(157, 105, 174, 30);
		frame.getContentPane().add(textAmount);
		
		JButton btnContribute = new JButton("CONTRIBUTE");
		btnContribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		    	LocalDateTime now = LocalDateTime.now();
		    	String ContribDate = dtf.format(now);
		    	String idGenerator = ContribDate.substring(0,10) +"."+ ContribDate.substring(11,19);
				
//				String sqlInsert = "INSERT INTO MembContribution VALUES(?,?,?,?)";
				String sqlInsert = "INSERT INTO membcontribution VALUES(?,?,?,?)";
				try {
					pst = conn.prepareStatement(sqlInsert);
					
					pst.setString(1, "C_"+idGenerator);
					pst.setInt(2, ID);
					pst.setDouble(3,  Double.parseDouble(textAmount.getText()));
					pst.setString(4, ContribDate);
					
					pst.execute();
					
					System.out.println("Sent to database");
					UserNavScreen navScreen = new UserNavScreen(ID);
					navScreen.run(ID);
					
					pst.close();
					conn.close();
					frame.dispose();  
				}catch (Exception err) {
					JOptionPane.showMessageDialog(null, "System update experienced "+ err);
					System.out.println(err);
				}
			}
		});
		btnContribute.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnContribute.setBackground(new Color(135, 206, 235));
		btnContribute.setBounds(10, 202, 158, 29);
		frame.getContentPane().add(btnContribute);
		
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
		btnBack.setBounds(280, 202, 96, 29);
		frame.getContentPane().add(btnBack);
	}

}
