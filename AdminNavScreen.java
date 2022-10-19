import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminNavScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			AdminNavScreen window = new AdminNavScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AdminNavScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 782, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTROL SCREEN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(229, 11, 301, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 97, 234, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("USERS");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(74, 72, 120, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnMembersView = new JButton("VIEW MEMBERS");
		btnMembersView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMembers view = new ViewMembers();
				view.run();
				frame.dispose();
			}
		});
		btnMembersView.setBackground(new Color(0, 255, 255));
		btnMembersView.setBounds(58, 110, 136, 23);
		frame.getContentPane().add(btnMembersView);
		
		JButton btnViewGroups = new JButton("VIEW GROUPS");
		btnViewGroups.setBackground(new Color(0, 255, 255));
		btnViewGroups.setBounds(58, 160, 136, 23);
		frame.getContentPane().add(btnViewGroups);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(242, 274, 261, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOANS");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(306, 236, 120, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnViewLoans = new JButton("VIEW LOANS");
		btnViewLoans.setBackground(Color.CYAN);
		btnViewLoans.setBounds(290, 287, 136, 23);
		frame.getContentPane().add(btnViewLoans);
		
		JButton btnViewRepayments = new JButton("VIEW REPAYMENTS");
		btnViewRepayments.setBackground(Color.CYAN);
		btnViewRepayments.setBounds(275, 332, 164, 23);
		frame.getContentPane().add(btnViewRepayments);
		
		JButton btnViewInterests = new JButton("VIEW INTERESTS");
		btnViewInterests.setBackground(Color.CYAN);
		btnViewInterests.setBounds(290, 374, 136, 23);
		frame.getContentPane().add(btnViewInterests);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(503, 97, 253, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("ORGANISATION");
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(552, 72, 120, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnViewDividends = new JButton("VIEW DIVIDENDS");
		btnViewDividends.setBackground(Color.CYAN);
		btnViewDividends.setBounds(536, 110, 136, 23);
		frame.getContentPane().add(btnViewDividends);
		
		JButton btnViewIncome = new JButton("VIEW INCOME");
		btnViewIncome.setBackground(Color.CYAN);
		btnViewIncome.setBounds(536, 160, 136, 23);
		frame.getContentPane().add(btnViewIncome);
		
		JButton btnViewRegistrations = new JButton("VIEW REGISTRATIONS");
		btnViewRegistrations.setBackground(Color.CYAN);
		btnViewRegistrations.setBounds(518, 208, 174, 23);
		frame.getContentPane().add(btnViewRegistrations);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBackground(new Color(199, 21, 133));
		btnLogout.setBounds(620, 427, 136, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnExit = new JButton("EXIT SYSTEM");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Mwanzo Baraka System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setBounds(10, 427, 136, 23);
		frame.getContentPane().add(btnExit);
	}
}
