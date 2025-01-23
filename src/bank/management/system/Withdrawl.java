
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JButton withdraw, back;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber)
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
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setBounds(320, 400,100, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
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
        if (ae.getSource() == withdraw)
        {
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the  amount to withdraw");
            }
            else
            {
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Withdraw', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Successfylly.");
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
        new Withdrawl("");
    }
}
