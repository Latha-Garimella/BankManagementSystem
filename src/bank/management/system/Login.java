package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to my ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 20, 400, 100);
        add(text);
        
        JLabel cardno = new JLabel("Card no:");
        cardno.setFont(new Font("Osward", Font.PLAIN, 30));
        cardno.setBounds(120, 130, 150, 100);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 170, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.PLAIN, 30));
        pin.setBounds(120, 200, 140, 100);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 235, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
       
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login)
        {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where CARD_NO = '"+cardnumber+"' and PIN_NO = '"+pinnumber+"' ";
            try
            {
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin number.");
                }
            }
            catch (Exception e)
                    {
                        System.out.println(e);
                    }
        }
        else if (ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
    
}