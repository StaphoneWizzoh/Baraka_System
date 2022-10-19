import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationScreen {

	private JFrame frame;
	private JTextField textIDNum;
	private JTextField textAmount;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ApplicationScreen window = new ApplicationScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ApplicationScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 538, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOAN APPLICATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 11, 250, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 90, 104, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textIDNum = new JTextField();
		textIDNum.setBounds(139, 88, 118, 18);
		frame.getContentPane().add(textIDNum);
		textIDNum.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Bodoni MT", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(25, 140, 104, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(139, 138, 118, 18);
		frame.getContentPane().add(textAmount);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnApply.setBackground(new Color(135, 206, 235));
		btnApply.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnApply.setBounds(25, 281, 118, 29);
		frame.getContentPane().add(btnApply);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserNavScreen nav = new UserNavScreen();
				nav.run();
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(199, 21, 133));
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBounds(416, 281, 96, 29);
		frame.getContentPane().add(btnBack);
	}
}
