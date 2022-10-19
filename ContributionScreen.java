import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContributionScreen {

	private JFrame frame;
	private JTextField textIDNumber;
	private JTextField textAmount;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ContributionScreen window = new ContributionScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ContributionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 556, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTRIBUTION SCREEN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(146, 11, 251, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1.setBounds(43, 96, 104, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textIDNumber = new JTextField();
		textIDNumber.setColumns(10);
		textIDNumber.setBounds(157, 94, 118, 18);
		frame.getContentPane().add(textIDNumber);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(43, 146, 104, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(157, 144, 118, 18);
		frame.getContentPane().add(textAmount);
		
		JButton btnContribute = new JButton("CONTRIBUTE");
		btnContribute.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnContribute.setBackground(new Color(135, 206, 235));
		btnContribute.setBounds(10, 277, 158, 29);
		frame.getContentPane().add(btnContribute);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserNavScreen nav = new UserNavScreen();
				nav.run();
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setBounds(434, 277, 96, 29);
		frame.getContentPane().add(btnBack);
	}

}
