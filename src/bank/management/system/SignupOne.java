
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
//import com.toedter.calender.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, stateTextField, cityTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;

    SignupOne() 
    {
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 10, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page-1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 70, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 20);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        nameTextField.setBounds(300, 140, 400, 25);
        add(nameTextField);
        
        JLabel Fname = new JLabel("Father's Name: ");
        Fname.setFont(new Font("Raleway", Font.BOLD, 15));
        Fname.setBounds(100, 190, 150, 20);
        add(Fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        fnameTextField.setBounds(300, 190, 400, 25);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 150, 20);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 25);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 20);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 20);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 20);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 100, 20);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailTextField.setBounds(300, 340, 400, 25);
        add(emailTextField);
        
        JLabel maritalstatus = new JLabel("Marital Status: ");
        maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalstatus.setBounds(100, 390, 150, 20);
        add(maritalstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 20);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 20);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 20);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        addressTextField.setBounds(300, 440, 400, 25);
        add(addressTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 490, 100, 20);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        stateTextField.setBounds(300, 490, 400, 25);
        add(stateTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 540, 100, 20);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        cityTextField.setBounds(300, 540, 400, 25);
        add(cityTextField);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 100, 20);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinTextField.setBounds(300, 590, 400, 25);
        add(pinTextField);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(600, 660, 100, 25);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(230, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random; //long
        String name = nameTextField.getText(); //set Text
        String fname = nameTextField.getName();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if (female.isSelected())
                {
                    gender = "Female";
                }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if (unmarried.isSelected())
                {
                    marital = "Unmarried";
                }
        else if (other.isSelected())
        {
            marital = "Other";
        }
        String address = addressTextField.getText();
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        
        
        try
        {
            if (name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+state+"', '"+city+"', '"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[])
    {
        new SignupOne();
    }
}
