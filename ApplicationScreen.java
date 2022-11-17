import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ApplicationScreen {

	private JFrame frame;
	private JTextField textAmount;
	
	private int ID;
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	LoginModel model = new LoginModel();

	/**
	 * Launch the application.
	 */
	public void run(int id) {
		try {
			ApplicationScreen window = new ApplicationScreen(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ApplicationScreen(int id) {
		this.ID = id;
		initialize();
		conn = DatabaseConnection.ConnectMySQLDb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 417, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOAN APPLICATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(74, 11, 250, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(25, 112, 104, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(139, 110, 172, 29);
		frame.getContentPane().add(textAmount);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		    	LocalDateTime now = LocalDateTime.now();
		    	String AppDate = dtf.format(now);
		    	String idGenerator = AppDate.substring(0,10) +"."+ AppDate.substring(11,19);
				
//				String sqlInsert = "INSERT INTO MembLoanApplication VALUES(?,?,?,?)";
				String sqlInsert = "INSERT INTO membloanapplication VALUES(?,?,?,?)";
				try {
					pst = conn.prepareStatement(sqlInsert);
					
					pst.setString(1, "L_"+idGenerator);
					pst.setInt(2, ID);
					pst.setDouble(3,  Double.parseDouble(textAmount.getText()));
					pst.setString(4, AppDate);
					
					pst.execute();
					
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
		btnApply.setBackground(new Color(135, 206, 235));
		btnApply.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnApply.setBounds(25, 216, 118, 29);
		frame.getContentPane().add(btnApply);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserNavScreen nav = new UserNavScreen(ID);
				nav.run(ID);
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBounds(286, 216, 96, 29);
		frame.getContentPane().add(btnBack);
	}
}
