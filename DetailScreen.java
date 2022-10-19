import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetailScreen {

	public JFrame frame;
	public String NAME,EMAIL,CONTACT,REGDATE;
	
	

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getCONTACT() {
		return CONTACT;
	}

	public void setCONTACT(String cONTACT) {
		CONTACT = cONTACT;
	}

	public String getREGDATE() {
		return REGDATE;
	}

	public void setREGDATE(String rEGDATE) {
		REGDATE = rEGDATE;
	}

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			DetailScreen window = new DetailScreen();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public DetailScreen() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		System.out.println(REGDATE);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 565, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DETAIL SCREEN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 11, 315, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 65, 124, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		Label textUsername = new Label(getNAME());
		textUsername.setBounds(140, 66, 106, 22);
		frame.getContentPane().add(textUsername);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreen.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBackground(new Color(220, 20, 60));
		btnLogout.setBounds(10, 337, 118, 23);
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
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(421, 337, 118, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblEmail.setBounds(10, 109, 124, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblContact.setBounds(10, 155, 124, 23);
		frame.getContentPane().add(lblContact);
		
		JLabel lblRegDate = new JLabel("Reg. Date");
		lblRegDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegDate.setFont(new Font("Swis721 BT", Font.ITALIC, 16));
		lblRegDate.setBounds(10, 203, 124, 23);
		frame.getContentPane().add(lblRegDate);
		
		Label textEmail = new Label(getEMAIL());
		textEmail.setBounds(140, 109, 106, 22);
		frame.getContentPane().add(textEmail);
		
		Label textContact = new Label(getCONTACT());
		textContact.setBounds(140, 155, 106, 22);
		frame.getContentPane().add(textContact);
		
		Label textRegDate = new Label(getREGDATE());
		textRegDate.setBounds(140, 203, 106, 22);
		frame.getContentPane().add(textRegDate);
	}
}
