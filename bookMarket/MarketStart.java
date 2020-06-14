package bookMarket;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarketStart extends JPanel {
	private JTextField logInID;
	private JTextField logInPassword;

	MarketStart(){
		intialize();
	}
	
	public void intialize() {
		JLabel lblBookmarket_1 = new JLabel("BooKMarket");
		lblBookmarket_1.setBounds(93, 27, 242, 52);
		lblBookmarket_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 46));
		add(lblBookmarket_1);
		
		logInID = new JTextField();
		logInID.setBounds(71, 168, 207, 27);
		add(logInID);
		logInID.setColumns(17);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(17, 165, 37, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW:");
		lblNewLabel_1.setBounds(17, 212, 46, 21);
		add(lblNewLabel_1);
		
		logInPassword = new JTextField();
		logInPassword.setBounds(71, 204, 207, 27);
		add(logInPassword);
		logInPassword.setColumns(10);
		
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.setBounds(295, 161, 125, 72);
		add(btnLogIn);
		
		JButton btnUserRegister = new JButton("New Register");
		
		btnUserRegister.setBounds(146, 321, 154, 52);
		add(btnUserRegister);
		
		
	}

}
