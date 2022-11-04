import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRepayments {

	private JFrame frame;
	private JTable table;
	
	private int ID;

	/**
	 * Launch the application.
	 */
	public void run(int id) {
		try {
			ViewRepayments window = new ViewRepayments(id);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ViewRepayments(int id) {
		this.ID = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 758, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMwanzoBarakaLoan = new JLabel("MWANZO BARAKA LOAN REPAYMENTS");
		lblMwanzoBarakaLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblMwanzoBarakaLoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMwanzoBarakaLoan.setBounds(134, 11, 425, 42);
		frame.getContentPane().add(lblMwanzoBarakaLoan);
		
		table = new JTable();
		table.setBounds(34, 61, 662, 353);
		frame.getContentPane().add(table);
		
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 11));
		btnGenerate.setBackground(new Color(135, 206, 250));
		btnGenerate.setBounds(288, 442, 119, 23);
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
		btnBack.setBounds(10, 478, 89, 23);
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
		btnQuitSystem.setBounds(566, 478, 160, 23);
		frame.getContentPane().add(btnQuitSystem);
	}

}
