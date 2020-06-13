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

public class UserInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtWithout;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTable table;
	JPanel panel = new JPanel();
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
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
	public void marketIn() {
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 450, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		frame.getContentPane().add(panel, "name_1988128391982900");
		panel.setLayout(null);
		
		JLabel lblBookmarket_1 = new JLabel("BooKMarket");
		lblBookmarket_1.setBounds(93, 27, 242, 52);
		lblBookmarket_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 46));
		panel.add(lblBookmarket_1);
		
		textField = new JTextField();
		textField.setBounds(71, 168, 207, 27);
		panel.add(textField);
		textField.setColumns(17);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(17, 165, 37, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW:");
		lblNewLabel_1.setBounds(17, 212, 46, 21);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(71, 204, 207, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBounds(295, 161, 125, 72);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Register");
		btnNewButton_1.setBounds(146, 321, 154, 52);
		panel.add(btnNewButton_1);
		
		JPanel userRegister = new JPanel();
		frame.getContentPane().add(userRegister, "name_1988215095290800");
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
		
		JButton btnNewButton_2 = new JButton("register");
		btnNewButton_2.setBounds(153, 408, 125, 29);
		userRegister.add(btnNewButton_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 146, 190, 27);
		userRegister.add(textField_2);
		textField_2.setColumns(15);
		
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
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_1992470234600800");
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 98, 272, 257);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
