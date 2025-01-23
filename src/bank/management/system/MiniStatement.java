
package bank.management.system;

import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    String pinnumber;
    
    MiniStatement(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 110, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        
        int bal = 0;
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where PIN_NO = '"+pinnumber+"'");
            
            while(rs.next())
            {
                card.setText("Card Number: " + rs.getString("CARD_NO").substring(0, 4) + "XXXXXXXX" + rs.getString("CARD_NO").substring(12));
                
            }
        }
        catch(Exception e)
            {
                System.out.println(e);
            }
        
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where PIN = '"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                    {
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your Current Balance is Rs " + bal);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[])
    {
        
        new MiniStatement("");
    }
}
