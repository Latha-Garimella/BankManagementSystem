
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pinTextField, repinTextField;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(770, 770, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 770, 770);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        text.setBounds(200, 240, 200, 30);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pintext = new JLabel("Enter PIN: ");
        pintext.setFont(new Font("Raleway", Font.BOLD, 13));
        pintext.setBounds(150, 295, 100, 20);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinTextField.setBounds(290, 290, 150, 25);
        image.add(pinTextField);
        
        JLabel repintext = new JLabel("Re-Enter Your PIN: ");
        repintext.setFont(new Font("Raleway", Font.BOLD, 13));
        repintext.setBounds(150, 330, 200, 20);
        repintext.setForeground(Color.WHITE);
        image.add(repintext);
        
        repinTextField = new JPasswordField();
        repinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        repinTextField.setBounds(290, 325, 150, 25);
        image.add(repinTextField);
        
        change = new JButton("CHANGE");
        change.setBounds(320, 410, 100, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(170, 410, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(770, 770);
        setLocation(300, 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change)
        {
            try
            {
            String npin = pinTextField.getText();
            String rpin = repinTextField.getText();
            
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not Match");
                return;
            }
            else if (npin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter New PIN");
                return;
            }
            else if (rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Re-enter New PIN");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set PIN = '"+rpin+"' where pin = '"+pinnumber+"'"; 
            String query2 = "update login set PIN_NO = '"+rpin+"' where PIN_NO = '"+pinnumber+"'";
            String query3 = "update signupthree set PIN_NO = '"+rpin+"' where PIN_NO = '"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            catch (Exception e)
                {
                    System.out.println(e);
                }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
