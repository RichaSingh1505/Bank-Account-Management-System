package bank;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JLabel 	lblWelcome,lblCardNo,lblPinNo;
	JTextField tfCardNo;
	JPasswordField pfPinNo;
	JButton btnLogin, btnClear, btnSignup;
	
	public Login() {
		setTitle("Bank Management System");
		setLayout(null);
		
		lblWelcome=new JLabel("Welcome To Bank System");
		lblWelcome.setFont(new Font("Arial",Font.BOLD,35));
		lblWelcome.setBounds(200,40,530,40);
		add(lblWelcome);
		
		lblCardNo=new JLabel("Enter Card No:");
		lblCardNo.setFont(new Font("Tahoma",Font.BOLD,25));
		lblCardNo.setBounds(120,150,400,30);
		add(lblCardNo);
		
		tfCardNo=new JTextField(20);
		tfCardNo.setBounds(350,150,230,30);
		tfCardNo.setFont(new Font("Tahoma",Font.BOLD,15));
		add(tfCardNo);
		
		lblPinNo=new JLabel("Enter PIN No:");
		lblPinNo.setFont(new Font("Tahoma",Font.BOLD,25));
		lblPinNo.setBounds(120,250,400,30);
		add(lblPinNo);
		
		pfPinNo=new JPasswordField(20);
		pfPinNo.setBounds(350,250,230,30);
		pfPinNo.setFont(new Font("Tahoma",Font.BOLD,15));
		add(pfPinNo);
		
		btnLogin=new JButton("Login.");
		btnLogin.setBackground(Color.black);
		btnLogin.setForeground(Color.white);
		
		btnClear=new JButton("Clear");
		btnClear.setBackground(Color.black);
		btnClear.setForeground(Color.white);
		
		btnSignup=new JButton("Sign Up");
		btnSignup.setBackground(Color.black);
		btnSignup.setForeground(Color.white);
		
		btnLogin.setFont(new Font("Tahoma",Font.BOLD,15));
		btnLogin.setBounds(300,300,100,40);
		add(btnLogin);
		
		btnClear.setFont(new Font("Tahoma",Font.BOLD,15));
		btnClear.setBounds(400,300,100,40);
		add(btnClear);
		
		btnSignup.setFont(new Font("Tahoma",Font.BOLD,15));
		btnSignup.setBounds(500,300,100,40);
		add(btnSignup);
		
		btnLogin.addActionListener(this);
		btnClear.addActionListener(this);
		btnSignup.addActionListener(this);
		
		
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setSize(800, 500);
		setLocation(400, 200);
		
	}

	public static void main(String[] args) {
		Login obj=new Login();	
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource()==btnLogin) {
				ConnectionFactory cf =new ConnectionFactory();
				String cardNum=tfCardNo.getText();
				String pin=pfPinNo.getText();
				
				String query="Select * from Login where cardnumber='"+cardNum+"' and pin='"+pin+"'";
				ResultSet rs=cf.stmt.executeQuery(query); 
				if(rs.next()) {
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Either CardNum or Pin Num is Wrong");
				}
			}
			else if(ae.getSource()==btnClear) {
				tfCardNo.setText("");
				pfPinNo.setText("");
				
			}
			else if(ae.getSource()==btnSignup) {
				this.setVisible(false);
				new Signup();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
