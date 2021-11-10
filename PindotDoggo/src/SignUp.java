import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class SignUp {
	private JFrame frame;
	private JLabel lblUser, lblPassword, lblLogo;
	private JTextField tfUser;
	private JPasswordField pfPassword;
	private JButton btnSignUp;
	private ImageIcon iconPindotDoggo, imgWindowIcon;
	
	public SignUp() {
		frame = new JFrame("Create Account");
		
		lblUser = new JLabel("Username:");
		lblUser.setBounds(30, 120, 80, 25);
		lblUser.setForeground(Color.WHITE);
		tfUser = new JTextField();
		tfUser.setBounds(100, 120, 180, 25);

		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(30, 150, 80, 25);
		pfPassword = new JPasswordField();
		pfPassword.setBounds(100, 150, 180, 25);
		
		btnSignUp = new JButton("Create Account");
		btnSignUp.setBackground(new Color(0xFFA31A));
		btnSignUp.setBounds(100, 180, 180, 25);
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.addActionListener(new SignUpListener());
		
		imgWindowIcon = new ImageIcon("../img/pindot_doggo_icon.png");
		frame.setIconImage(imgWindowIcon.getImage());
		
		iconPindotDoggo = new ImageIcon("../img/pindot_doggo.png");
		lblLogo = new JLabel(iconPindotDoggo);
		lblLogo.setBounds(30, 20, 253, 74);
		
		frame.add(lblLogo);
		frame.add(lblUser);
		frame.add(tfUser);
		frame.add(lblPassword);
		frame.add(pfPassword);
		frame.add(btnSignUp);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(325, 500);
		frame.getContentPane().setBackground(new Color(0x0D0D0D));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	private class SignUpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnSignUp) {
				String username = tfUser.getText();
				String password = new String(pfPassword.getPassword());
				try {
					FileWriter write = new FileWriter("../login_info.txt", true);
					BufferedWriter next = new BufferedWriter(write);
					next.newLine();
					next.write(username + "," + password);
					next.close();
					frame.dispose();
					new LoginGUI();

				} catch (IOException x) {
					// TODO Auto-generated catch block
					x.printStackTrace();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new SignUp();
	}

}
