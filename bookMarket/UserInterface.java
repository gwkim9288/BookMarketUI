package bookMarket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class UserInterface {

	private JFrame frame;
	CardLayout layout;
	private JTextField logInID;
	private JTextField logInPassword;
	private JTextField textField_;
	private JTextField textField_3;
	private JTextField txtWithout;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTable table;
	JPanel marketStart = new JPanel();
	private JTable table_1;
	JPanel userRegister;
	JButton btnUserRegister;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
					window.marketExcution();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void marketExcution() {
		layout.show(frame.getContentPane(), "marketStart");
		btnUserRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				if(btn.getText().equals("Click"))
					btn.setText("Hello");
				else 
					btn.setText("Click");
			}
		});
		btnUserRegister.setAction(action);
		userRegister();
	}
	
	public void userRegister() {
		layout.show(frame.getContentPane(), "userRegister");
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 450, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(layout = new CardLayout(0, 0));
		
		//page:Start Market application
		
		frame.getContentPane().add(marketStart, "marketStart");
		marketStart.setLayout(null);
		
		JLabel lblBookmarket_1 = new JLabel("BooKMarket");
		lblBookmarket_1.setBounds(93, 27, 242, 52);
		lblBookmarket_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 46));
		marketStart.add(lblBookmarket_1);
		
		logInID = new JTextField();
		logInID.setBounds(71, 168, 207, 27);
		marketStart.add(logInID);
		logInID.setColumns(17);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(17, 165, 37, 21);
		marketStart.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW:");
		lblNewLabel_1.setBounds(17, 212, 46, 21);
		marketStart.add(lblNewLabel_1);
		
		logInPassword = new JTextField();
		logInPassword.setBounds(71, 204, 207, 27);
		marketStart.add(logInPassword);
		logInPassword.setColumns(10);
		
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.setBounds(295, 161, 125, 72);
		marketStart.add(btnLogIn);
		
		JButton btnUserRegister = new JButton("New Register");
		
		btnUserRegister.setBounds(146, 321, 154, 52);
		marketStart.add(btnUserRegister);
		
		//page: when click "New Register"
		
		JPanel userRegister = new JPanel();
		frame.getContentPane().add(userRegister, "userRegister");
		userRegister.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New Register");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(17, 58, 246, 42);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		userRegister.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("name:");
		lblNewLabel_3.setBounds(17, 149, 78, 21);
		userRegister.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("password:");
		lblNewLabel_4.setBounds(17, 220, 119, 21);
		userRegister.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("phone number");
		lblNewLabel_5.setBounds(17, 288, 119, 21);
		userRegister.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setBounds(17, 354, 119, 21);
		userRegister.add(lblNewLabel_6);
		
		JButton btnConfirmUser = new JButton("register");
		btnConfirmUser.setBounds(153, 408, 125, 29);
		userRegister.add(btnConfirmUser);
		
		textField_ = new JTextField();
		textField_.setBounds(153, 146, 190, 27);
		userRegister.add(textField_);
		textField_.setColumns(15);
		
		textField_3 = new JTextField();
		textField_3.setBounds(153, 217, 190, 27);
		userRegister.add(textField_3);
		textField_3.setColumns(15);
		
		txtWithout = new JTextField();
		txtWithout.setForeground(Color.LIGHT_GRAY);
		txtWithout.setText("without '-'");
		txtWithout.setBounds(153, 285, 190, 27);
		userRegister.add(txtWithout);
		txtWithout.setColumns(15);
		
		textField_5 = new JTextField();
		textField_5.setBounds(153, 351, 190, 27);
		userRegister.add(textField_5);
		textField_5.setColumns(15);
		
		//page: after login
		
		JPanel marketIn = new JPanel();
		frame.getContentPane().add(marketIn, "name_1988235523678600");
		marketIn.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(17, 37, 341, 21);
		marketIn.add(lblNewLabel_7);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(17, 402, 156, 57);
		marketIn.add(btnNewButton_4);
		
		JPanel bookFindPanel = new JPanel();
		bookFindPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bookFindPanel.setForeground(new Color(0, 0, 0));
		bookFindPanel.setBounds(17, 73, 394, 329);
		marketIn.add(bookFindPanel);
		bookFindPanel.setLayout(null);
		
		JLabel lblFindBook = new JLabel("Find Book");
		lblFindBook.setBounds(5, 6, 129, 32);
		bookFindPanel.add(lblFindBook);
		lblFindBook.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 27));
		
		textField_4 = new JTextField();
		textField_4.setBounds(139, 8, 156, 27);
		bookFindPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setBounds(300, 7, 89, 29);
		bookFindPanel.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(17, 285, 125, 29);
		bookFindPanel.add(btnNewButton_7);
		
		//result of 'find Book'
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(45, 124, 332, 127);
		bookFindPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_8 = new JButton("New button");
		scrollPane.setRowHeaderView(btnNewButton_8);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(172, 402, 150, 57);
		marketIn.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(322, 402, 89, 57);
		marketIn.add(btnNewButton_6);
		
		//
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_1992470234600800");
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 98, 394, 361);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		scrollPane_1.setRowHeaderView(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_2.add(btnNewButton_10);
		
		JLabel lblMyBook = new JLabel("MY BOOK");
		lblMyBook.setBounds(17, 37, 111, 46);
		panel_1.add(lblMyBook);
		
		JButton btnNewButton_11 = new JButton("Back");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_11.setBounds(338, 42, 73, 41);
		panel_1.add(btnNewButton_11);
		
		JPanel bookRegister = new JPanel();
		frame.getContentPane().add(bookRegister, "name_146048791974900");
		bookRegister.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Name");
		lblNewLabel_8.setBounds(17, 60, 78, 20);
		bookRegister.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Author");
		lblNewLabel_9.setBounds(17, 110, 78, 21);
		bookRegister.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Publisher");
		lblNewLabel_10.setBounds(17, 160, 78, 21);
		bookRegister.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("ISBN");
		lblNewLabel_11.setBounds(17, 210, 78, 21);
		bookRegister.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Price");
		lblNewLabel_12.setBounds(17, 260, 78, 21);
		bookRegister.add(lblNewLabel_12);
		
		textField_6 = new JTextField();
		textField_6.setBounds(140, 57, 156, 27);
		bookRegister.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(140, 110, 156, 27);
		bookRegister.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(140, 157, 156, 27);
		bookRegister.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(140, 207, 156, 27);
		bookRegister.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(140, 257, 156, 27);
		bookRegister.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_12 = new JButton("SELL");
		btnNewButton_12.setBounds(152, 413, 125, 29);
		bookRegister.add(btnNewButton_12);
		
		JLabel lblNewLabel_13 = new JLabel("Publishing Year");
		lblNewLabel_13.setBounds(17, 310, 123, 21);
		bookRegister.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("State");
		lblNewLabel_14.setBounds(17, 360, 78, 21);
		bookRegister.add(lblNewLabel_14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(140, 307, 156, 27);
		bookRegister.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(140, 357, 156, 27);
		bookRegister.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(333, 13, 78, 29);
		bookRegister.add(btnBack);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}