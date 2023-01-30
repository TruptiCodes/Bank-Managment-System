package pkg1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegisterPage2pkg3 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException { 
		Class.forName("com.mysql.cj.jdbc.Driver");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage2pkg3 window = new RegisterPage2pkg3();
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
	public RegisterPage2pkg3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 472, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER PAGE");
		lblNewLabel.setBounds(30, 11, 382, 46);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 45));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME");
		lblNewLabel_1.setBounds(30, 100, 150, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME");
		lblNewLabel_1_1.setBounds(30, 140, 150, 30);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("STREET");
		lblNewLabel_1_1_1.setBounds(30, 180, 135, 30);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CITY");
		lblNewLabel_1_1_2.setBounds(30, 220, 135, 30);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("GMAIL");
		lblNewLabel_1_1_3.setBounds(30, 260, 150, 30);
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("MOBILE NO.");
		lblNewLabel_1_1_4.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_1_4.setBounds(30, 300, 150, 30);
		frame.getContentPane().add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("ACCOUNT TYPE");
		lblNewLabel_1_1_5.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_1_5.setBounds(30, 340, 198, 30);
		frame.getContentPane().add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("AMOUNT");
		lblNewLabel_1_1_6.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_1_6.setBounds(30, 380, 150, 30);
		frame.getContentPane().add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_8 = new JLabel("PASSWORD");
		lblNewLabel_1_1_8.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel_1_1_8.setBounds(30, 420, 150, 30);
		frame.getContentPane().add(lblNewLabel_1_1_8);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(235, 100, 200, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(235, 140, 200, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(235, 180, 200, 28);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(235, 220, 200, 28);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(235, 260, 200, 28);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(235, 300, 200, 28);
		frame.getContentPane().add(textField_5);

		//drop down list to select account type
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Saving", "Current", "Fixed"}));
		comboBox.setBounds(235, 340, 200, 28);
		frame.getContentPane().add(comboBox);

//		String Acc_type[] = {"Saving","Current","Fixed","Recurring"};
//		JComboBox cb = new JComboBox(Acc_type);
//		cb.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		//cb.setColumns(10);
//		cb.setBounds(235, 340, 200, 28);
//		frame.getContentPane().add(cb);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setColumns(10);
		textField_6.setBounds(235, 380, 200, 28);
		frame.getContentPane().add(textField_6);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(235, 420, 200, 30);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 80, 430, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 465, 430, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(165, 478, 130, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//get Data from textField
				String name = textField.getText() + " " + textField_1.getText();
				String address = textField_2.getText() + " " + textField_3.getText();
				String gmail = textField_4.getText();
				String mobile = textField_5.getText();
				String AccType = (String) comboBox.getSelectedItem();
				String strAmount = textField_6.getText();
				String pwd = passwordField.getText();
				
				//connection to mysql server
				String url = "jdbc:mysql://localhost:3306/banksystem";
				String Uname = "root";
				String pass = "";
				
				Connection conn ;
				
				try {
					conn = DriverManager.getConnection(url, Uname, pass);
					String query = "insert into userregisterdata value(?,?,?,?,?,?,?,now())";
					
					PreparedStatement pt = conn.prepareStatement(query);
					
					int mobileNo = Integer.parseInt(mobile);
					int Amount = Integer.parseInt(strAmount);
					
					pt.setString(1, name);
					pt.setString(2, address);
					pt.setString(3, gmail);
					pt.setInt(4, mobileNo);
					pt.setString(5, AccType);
					pt.setInt(6, Amount);
					pt.setString(7, pwd);
					
					int count = pt.executeUpdate();
					System.out.println(count+" row/s was affected.");
					
					pt.close();
					conn.close();
					
					System.out.println("Register successfully"); 
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Name : "+name);
				System.out.println("address : "+address);
				System.out.println("gmail : "+gmail);
				System.out.println("mobile : "+mobile);
				System.out.println("Acc type : "+AccType);
				System.out.println("Amount : "+strAmount);
				System.out.println("pwd : "+pwd); 
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton_1.setBounds(305, 478, 130, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Login");
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton_1_1.setBounds(25, 478, 130, 30);
		frame.getContentPane().add(btnNewButton_1_1);
		
	}
}
