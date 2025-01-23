
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770, 770, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 770, 770);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(160, 240, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 17));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 290, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(290, 290, 130, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 330, 130, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(290, 330, 130, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(150, 370, 130, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(290, 370, 130, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(290, 410, 130, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(770, 770);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
        
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
        else if (ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == ministatement)
        {
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Transactions("");
    }
}
