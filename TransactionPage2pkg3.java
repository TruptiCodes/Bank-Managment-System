package pkg1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class TransactionPage2pkg3{

	private JFrame frame;
	private JPasswordField passwordField;
	static Scanner sc = new Scanner(System.in);
	//static Date TransDate = new Date();
	static double Total_Amount=20000;
	static SimpleDateFormat formatter ;//= new SimpleDateFormat("yyyy");
	
	static Date TodayYear;
	static int RateOfInterest = 10;
	
	//connection to mysql database
	static String url = "jdbc:mysql://localhost:3306/banksystem";
	static String un = "root";
	static String pass =  "";
	
	Connection conn;
	PreparedStatement ps;
	

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionPage2pkg3 window = new TransactionPage2pkg3();
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
	public TransactionPage2pkg3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSACTION PAGE");
		lblNewLabel.setBounds(24, 11, 425, 46);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setBounds(35, 135, 155, 30);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AMOUNT");
		lblNewLabel_1_1_1.setBounds(35, 175, 123, 30);
		lblNewLabel_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(200, 95, 250, 30);
		textArea.setFont(new Font("Arial", Font.PLAIN, 23));
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(200, 175, 250, 30);
		textArea_2.setFont(new Font("Arial", Font.PLAIN, 23));
		frame.getContentPane().add(textArea_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 135, 250, 30);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 23));
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("WITHDRAW");
		btnNewButton.setBounds(24, 250, 180, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userGmail = textArea.getText();
				String userPassword = passwordField.getText();
				String str = textArea_2.getText();
				int amount = Integer.parseInt(str);
				
				//Create connection to database
				Connection conn;
				try {
					conn = DriverManager.getConnection(url,un,pass);
					Statement st = conn.createStatement();
				
					String query = "select u_gmail,u_pwd,u_amount from userregisterdata";
					ResultSet rs;
					
					rs= st.executeQuery(query);
//					System.out.println("Database data");
//					rs.next();
//					System.out.println("bankId : "+rs.getString(1));
//					System.out.println("userPwd : "+rs.getString(2));
//					System.out.println("amount : "+rs.getDouble(3));
//					Date TDate = rs.getDate(4);
//					System.out.println("transactionDate : "+ TDate);
//					System.out.println("SimpleInterest : "+ rs.getDouble(4));
					
				int flag = 0;
				
				while (rs.next()) {
					//Verify userGmail and password
					if(userGmail.contains(rs.getString(1)) && userPassword.contains(rs.getString(2))) {
						int Total_Amount = rs.getInt(3);
						
						//check if sufficient amount is available or not
						Total_Amount -= amount;
			
						//mysql query to update amount in database table
						query = "update userregisterdata set u_amount=? where u_gmail=? ";
						ps = conn.prepareStatement(query);
						ps.setInt(1 , Total_Amount);
						ps.setString(2 , rs.getString(1));
						ps.executeUpdate();
					
							
						//show remaining balance to user
						JOptionPane.showMessageDialog(null,"Remaining Amount : "+Total_Amount,"     Message",JOptionPane.PLAIN_MESSAGE);
							
						System.out.println("Remaining Amount : "+Total_Amount);
							
						//Set all values to null
						textArea.setText(null);
						textArea_2.setText(null);
						passwordField.setText(null);
						
//						}
//						else {
//							JOptionPane.showMessageDialog(null,"      Invalid Login","ERROR",JOptionPane.ERROR_MESSAGE);
							//System.out.println("Insufficient Fund");
//						}
						//System.out.println("Login successfully");
						//JOptionPane.showMessageDialog(null,"     Message","Login Successfully 👍",JOptionPane.PLAIN_MESSAGE);
						}
					else {
						JOptionPane.showMessageDialog(null,"      Invalid Login","ERROR",JOptionPane.ERROR_MESSAGE);
						textArea.setText(null);
		//				textArea_1.setText(null);
						textArea_2.setText(null);
						passwordField.setText(null);
						}
				}
				
				}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDebit = new JButton("DEBIT");
		btnDebit.setBounds(294, 250, 155, 35);
		btnDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userGmail = textArea.getText();
				int amount = Integer.parseInt(textArea_2.getText());
				String userPassword = passwordField.getText();
				
				try {
					conn = DriverManager.getConnection(url,un,pass);
					Statement st = conn.createStatement();
				
					String query = "select u_gmail,u_pwd,u_amount from userregisterdata";
					ResultSet rs;
					
					rs= st.executeQuery(query);
//					System.out.println("Database data");
//					rs.next();
//					System.out.println("bankId : "+rs.getString(1));
//					System.out.println("userPwd : "+rs.getString(2));
//					System.out.println("amount : "+rs.getDouble(3));
//					Date TDate = rs.getDate(4);
//					System.out.println("transactionDate : "+ TDate);
					
				int flag = 0;
				
				while (rs.next()) {
					//Verify user Gmail and password
					if(userGmail.contains(rs.getString(1)) && userPassword.contains(rs.getString(2))) {
						
						int Total_Amount = rs.getInt(3);
						Total_Amount = Total_Amount + amount;
						
						//mysql query to update amount in database table
						query = "update userregisterdata set u_amount=? where u_gmail=? ";
						ps = conn.prepareStatement(query);
						ps.setInt(1,Total_Amount);
						ps.setString(2,rs.getString(1));
						ps.executeUpdate();
						
						//show remaining balance to user
						JOptionPane.showMessageDialog(null,"Remaining Amount : "+Total_Amount,"     Message",JOptionPane.PLAIN_MESSAGE);
						
						System.out.println("Remaining Amount : "+Total_Amount);
						
						//Set all values to null
						textArea.setText(null);
		//				textArea_1.setText(null);
						textArea_2.setText(null);
						passwordField.setText(null);
						}
					else {
						JOptionPane.showMessageDialog(null,"      Invalid Login","ERROR",JOptionPane.ERROR_MESSAGE);
						textArea.setText(null);
	//					textArea_1.setText(null);
						textArea_2.setText(null);
						passwordField.setText(null);
						}
				}
				
				}	
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnDebit.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(btnDebit);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(145, 330, 157, 35);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 25));
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 75, 420, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(24, 310, 420, 2);
		frame.getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("GMAIL");
		lblNewLabel_1_2.setBounds(35, 95, 150, 30);
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(24, 225, 420, 2);
		frame.getContentPane().add(separator_1_1_1);
	}
}
