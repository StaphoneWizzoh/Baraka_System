import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserNavScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			UserNavScreen window = new UserNavScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public UserNavScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 583, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAVIGATION SCREEN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(177, 11, 253, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnDetailView = new JButton("VIEW DETAILS");
		btnDetailView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("DetailScreen");
				frame.dispose();
			}
		});
		btnDetailView.setBackground(new Color(102, 205, 170));
		btnDetailView.setBounds(10, 84, 155, 23);
		frame.getContentPane().add(btnDetailView);
		
		JButton btnLoanApplication = new JButton("LOAN APPLICATION");
		btnLoanApplication.setBackground(new Color(102, 205, 170));
		btnLoanApplication.setBounds(10, 148, 155, 23);
		frame.getContentPane().add(btnLoanApplication);
		
		JButton btnLoanRepay = new JButton("REPAY LOAN");
		btnLoanRepay.setBackground(new Color(102, 205, 170));
		btnLoanRepay.setBounds(10, 218, 155, 23);
		frame.getContentPane().add(btnLoanRepay);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBackground(new Color(220, 20, 60));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBounds(439, 84, 118, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnExit = new JButton("EXIT SYSTEM");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(439, 218, 118, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnContribute = new JButton("CONTRIBUTE");
		btnContribute.setBackground(new Color(102, 205, 170));
		btnContribute.setBounds(235, 270, 118, 23);
		frame.getContentPane().add(btnContribute);
	}
}
