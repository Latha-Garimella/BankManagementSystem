
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770, 770, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 770, 770);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(310, 420, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        int balance = 0;
        Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+ pinnumber+"'");
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                            {
                                balance += Integer.parseInt(rs.getString("amount"));
                            }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
            
            JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
            text.setForeground(Color.WHITE);
            text.setBounds(150, 260, 250, 30);
            //text.setFont(new Font("Raleway", Font.BOLD, 13));
            image.add(text);
        
        
        setSize(770,770);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
  
    
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}
