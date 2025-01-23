
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
//import com.toedter.calender.JDateChooser;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, exyes, exno;
    JDateChooser dateChooser;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, occupationComboBox, qualificationComboBox;
    String formno;

    SignupTwo(String formno) 
    {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2+++");
        
        
        JLabel additionaldetails = new JLabel("Additional Details: ");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 70, 400, 30);
        add(additionaldetails);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 20);
        add(religion);
        
        String valReligion[] = {"Select","Hindhu", "Muslim", "Christian", "Jainism", "Budhism", "Sikhism"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        religionComboBox.setBounds(300, 140, 400, 25);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);
        
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 150, 20);
        add(category);
        
        String valCategory[] = {"General", "OC", "OBC", "SC", "ST", "Other"};
        categoryComboBox = new JComboBox(valCategory);
        categoryComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        categoryComboBox.setBounds(300, 190, 400, 25);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);
        
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 150, 20);
        add(income);
        
        String valIncome[] = {"Null", "<1,50,000", "<5,00,000", "<9,00,000", "upto 15,00,000", "More than 15,00,000"};
        incomeComboBox = new JComboBox(valIncome);
        incomeComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        incomeComboBox.setBounds(300, 240, 400, 25);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);
        
        
        JLabel educational = new JLabel("Educational ");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 300, 150, 20);
        add(educational);
        
        
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 330, 150, 20);
        add(qualification);
        
        String valQualification[] = {"Non-Graduation", "Graduation", "Post Graduation", "Doctrate", "Others"};
        qualificationComboBox = new JComboBox(valQualification);
        qualificationComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        qualificationComboBox.setBounds(300, 320, 400, 25);
        qualificationComboBox.setBackground(Color.WHITE);
        add(qualificationComboBox);
        
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 150, 20);
        add(occupation);
        
        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired","Others"};
        occupationComboBox = new JComboBox(valOccupation);
        occupationComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        occupationComboBox.setBounds(300, 390, 400, 25);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);
        
        
        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 150, 20);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        panTextField.setBounds(300, 440, 400, 25);
        add(panTextField);
       
        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 180, 20);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        aadharTextField.setBounds(300, 490, 400, 25);
        add(aadharTextField);
        
        JLabel scitizen = new JLabel("Senior Citizen: ");
        scitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        scitizen.setBounds(100, 540, 170, 20);
        add(scitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 20);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 20);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup scitizengroup = new ButtonGroup();
        scitizengroup.add(syes);
        scitizengroup.add(sno);
        
        
        JLabel exaccount = new JLabel("Existing Account: ");
        exaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        exaccount.setBounds(100, 590, 180, 20);
        add(exaccount);
        
        exyes = new JRadioButton("Yes");
        exyes.setBounds(300, 590, 100, 20);
        exyes.setBackground(Color.white);
        add(exyes);
        
        exno = new JRadioButton("No");
        exno.setBounds(450, 590, 100, 20);
        exno.setBackground(Color.WHITE);
        add(exno);
        
        ButtonGroup eaccountgroup = new ButtonGroup();
        eaccountgroup.add(exyes);
        eaccountgroup.add(exno);
        
        
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
        
        String religion = (String) religionComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String qualification = (String) qualificationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        
        String seniorcitizen = null;
        if(syes.isSelected())
        {
            seniorcitizen = "Yes";
        }
        else if (sno.isSelected())
                {
                    seniorcitizen = "No";
                }
       
        String existingaccount = null;
        if(exyes.isSelected())
        {
            existingaccount = "Yes";
        }
        else if (exno.isSelected())
                {
                    existingaccount = "No";
                }
        
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        
        
        
        try
        {
            
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            //Signup3 obj
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}
