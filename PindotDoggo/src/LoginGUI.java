import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.*;

public class LoginGUI {

	private JFrame frame;
	private JLabel lblUser, lblPassword, lblLogo;
	private JTextField tfUser;
	private JPasswordField pfPassword;
	private JButton btnLogin, btnSignUp;
	private ImageIcon iconPindotDoggo, imgWindowIcon;
	private ImageIcon iconLoginAlert, iconWrongPassAlert;

	public LoginGUI(){
		frame = new JFrame("PindotDoggo Login");
    
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
		
		btnSignUp = new JButton("Signup");
		btnSignUp.setBackground(new Color(0xFFA31A));
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setBounds(100, 180, 75, 25);
		btnSignUp.addActionListener(new PogiListener());

		btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0xFFA31A));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBounds(180, 180, 100, 25);
		btnLogin.addActionListener(new PogiListener());

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
		frame.add(btnLogin);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(325, 500);
		frame.getContentPane().setBackground(new Color(0x0D0D0D));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private class PogiListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==btnLogin) {
				boolean isAccepted = true;
				try {
					FileInputStream file = new FileInputStream("../login_info.txt");
					Scanner scan = new Scanner(file);
					
					while(scan.hasNextLine()) {
						String username = tfUser.getText();
						String password = new String(pfPassword.getPassword());
						
						String line = scan.nextLine();
						String[] splitString = line.split(",");
						
						if(splitString[0].equals(username)) {
							if(splitString[0].equals(username) && splitString[1].equals(password)) {
								iconLoginAlert = new ImageIcon("../img/loginalert_icon.png");
								JOptionPane.showMessageDialog(frame, new JLabel("Login Successful", JLabel.CENTER), "PindotDoggo Login", 0, iconLoginAlert);
								frame.dispose();
								new PindotDoggo();
								isAccepted = true;
							}else {
								iconWrongPassAlert = new ImageIcon("../img/wrongpasswordalert_icon.png");
								JOptionPane.showMessageDialog(frame, new JLabel("Wrong password", JLabel.CENTER), "PindotDoggo Login", 0, iconWrongPassAlert);
								pfPassword.setText("");
								isAccepted = true;
							}
							break;
						}
						else {
							isAccepted = false;
						}
					}
					scan.close();
					if(!isAccepted) {
						String[] option = {"Yes", "Cancel"};
						int answer = JOptionPane.showOptionDialog(
								frame, 
								"Account does not exist! Would you like to create an account?", 
								"Error", 
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
								null, option, option[0]);
						if(answer == 0) {
							frame.dispose();
							new SignUp();
						}
						else
							tfUser.setText("");
							pfPassword.setText("");
					}
				} catch (Exception x) {
					// TODO Auto-generated catch block
					System.out.println("may error buddy!");
				}
			}
			if(e.getSource() == btnSignUp) {
				frame.dispose();
				new SignUp();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new LoginGUI();
	}

}