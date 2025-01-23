
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    
    Deposit(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 260, 400, 30);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(170, 310, 250, 30);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(320, 400,100, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(320, 435,100, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(800, 800);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the  amount to deposit");
            }
            else
            {
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfylly.");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main (String args[])
    {
        new Deposit("");
    }
}
