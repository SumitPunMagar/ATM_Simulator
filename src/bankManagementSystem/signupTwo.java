package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signupTwo extends JFrame implements ActionListener {

    long random;
    String formNumber;
    
    JLabel detailLabel;
    JLabel Religion, Income, Educational, Qualification, Occupation, PanNumber, CitizenshipNumber, SeniorCitizen, ExistingAccount;

    JComboBox religionBox, incomeBox, educationBox, occupationBox;

    String[] religionArr = {"Hindu", "Muslim", "Christian", "Others"};
    String[] incomeArr = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", ">5,00,000"};
    String[] educationArr = {"Non-Graduation", "Graduated", "Doctrate", "Others"};
    String[] occupationArr = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};

    JTextField panField, citizenshipNumField;

    JRadioButton yesSenior, noSenior;
    JRadioButton yesAccount, noAccount;

    JButton nextButton;

    // constructor
    public signupTwo(String formno){
        this.formNumber = formno;

        // Details label

        detailLabel = new JLabel("Page 2: Personal Details");
        detailLabel.setBounds(160,65,300,30);
        detailLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(detailLabel);


        // Religion

        Religion = new JLabel("Religion:");
        Religion.setBounds(40,155,150,30);
        Religion.setFont(new Font("Baufra",Font.BOLD,16));
        add(Religion);

        religionBox = new JComboBox(religionArr);
        religionBox.setBounds(230,155,300,30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        // Income

        Income = new JLabel("Income:");
        Income.setBounds(40,195,150,30);
        Income.setFont(new Font("Baufra",Font.BOLD,16));
        add(Income);

        incomeBox = new JComboBox(incomeArr);
        incomeBox.setBounds(230, 195,300,30);
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        // Educational Qualification

        Educational = new JLabel("Educational");
        Educational.setBounds(40,235,150,30);
        Educational.setFont(new Font("Baufra",Font.BOLD,16));
        add(Educational);


        Qualification = new JLabel("Qualification:");
        Qualification.setBounds(40,260,150,30);
        Qualification.setFont(new Font("Baufra",Font.BOLD,16));
        add(Qualification);

        educationBox = new JComboBox(educationArr);
        educationBox.setBounds(230,250,300,30);
        educationBox.setBackground(Color.white);
        add(educationBox);


        // Occupation

        Occupation = new JLabel("Occupation:");
        Occupation.setBounds(40,300,150,30);
        Occupation.setFont(new Font("Baufra",Font.BOLD,16));
        add(Occupation);


        occupationBox = new JComboBox(occupationArr);
        occupationBox.setBounds(230,295,300,30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);


        // PAN Number

        PanNumber = new JLabel("PAN Number:");
        PanNumber.setBounds(40,335,150,30);
        PanNumber.setFont(new Font("Baufra",Font.BOLD,16));
        add(PanNumber);

        panField = new JTextField();
        panField.setBounds(230,335,300,30);
        panField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(panField);

        // Citizenship Number

        CitizenshipNumber = new JLabel("Citizenship Number:");
        CitizenshipNumber.setBounds(40,370,200,30);
        CitizenshipNumber.setFont(new Font("Baufra",Font.BOLD,16));
        add(CitizenshipNumber);

        citizenshipNumField = new JTextField();
        citizenshipNumField.setBounds(230,370,300,30);
        citizenshipNumField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(citizenshipNumField);


        // Senior Citizen

        SeniorCitizen = new JLabel("Senior Citizen:");
        SeniorCitizen.setBounds(40,405,150,30);
        SeniorCitizen.setFont(new Font("Baufra",Font.BOLD,16));
        add(SeniorCitizen);


        yesSenior = new JRadioButton("Yes");
        yesSenior.setBounds(230,405,100,30);
        yesSenior.setFocusable(false);
        yesSenior.setBackground(Color.white);
        add(yesSenior);

        noSenior = new JRadioButton("No");
        noSenior.setBounds(345,405,100,30);
        noSenior.setBackground(Color.white);
        noSenior.setFocusable(false);
        add(noSenior);

        ButtonGroup senior = new ButtonGroup();
        senior.add(yesSenior);
        senior.add(noSenior);


        // Existing Account

        ExistingAccount = new JLabel("Existing Account:");
        ExistingAccount.setBounds(40,440,200,30);
        ExistingAccount.setFont(new Font("Baufra",Font.BOLD,16));
        add(ExistingAccount);


        yesAccount = new JRadioButton("Yes");
        yesAccount.setBounds(230,440,100,30);
        yesAccount.setFocusable(false);
        yesAccount.setBackground(Color.white);
        add(yesAccount);

        noAccount = new JRadioButton("No");
        noAccount.setBounds(345,440,100,30);
        noAccount.setBackground(Color.white);
        noAccount.setFocusable(false);
        add(noAccount);

        ButtonGroup existingAcc = new ButtonGroup();
        existingAcc.add(yesAccount);
        existingAcc.add(noAccount);




        // Next Button

        nextButton = new JButton("Next");
        nextButton.setBounds(430,500,100,30);
        nextButton.setFont(new Font("Railway",Font.BOLD,15));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);
        add(nextButton);






        setSize(600,600);
        setLocation(400,50);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = formNumber;
        String religion = (String) religionBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        String pan = panField.getText();
        String citizenshipNum = citizenshipNumField.getText();


        String seniorCitizen = null;
        if (yesSenior.isSelected()){
            seniorCitizen = "Yes";
        } else if (noSenior.isSelected()) {
            seniorCitizen = "No";
        }


        String existingAccount = null;
        if (yesAccount.isSelected()){
            existingAccount = "Yes";
        } else if (noAccount.isSelected()) {
            existingAccount = "No";
        }


        try{
            // form validation
            if (religion == null || religion.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please select one option");
            } else if (income == null || income.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select one option");
            }else if (education == null || education.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select one option");
            }else if (occupation == null || occupation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select one option");
            }else if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN number is required");
            }else if (citizenshipNum.equals("")) {
                JOptionPane.showMessageDialog(null, "Citizenship Number is required");
            }else if (seniorCitizen == null) {
                JOptionPane.showMessageDialog(null, "Please choose one");
            }else if (existingAccount == null) {
                JOptionPane.showMessageDialog(null, "Please choose one");
            }else {
//                 creating instance of Conn
                Conn c = new Conn();

                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+citizenshipNum+"', '"+seniorCitizen+"', '"+existingAccount+"')";

                c.s.executeUpdate(query);

                // signupThree object will appear and this frame will not be visible
                setVisible(false);
                new signupThree(formno).setVisible(true);
            }

        } catch (Exception e2){
            System.out.println(e2);
        }

    }

    public static void main(String[] args) {
        new signupTwo("");
    }
}




