package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {

    JLabel detailLabel, accountTypeLabel, cardNumberLabel, cardNumberPinLabel, pinLabel, pinNumberLabel, servicesRequiredLabel;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submitButton, cancelButton;
    String formno;

    // constructor
    signupThree(String formno){
        this.formno = formno;

        detailLabel = new JLabel("Page 3: Account Details");
        detailLabel.setBounds(160,35,300,30);
        detailLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(detailLabel);

        // Account Type

        accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(40,120,150,30);
        accountTypeLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(accountTypeLabel);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(40,160,150,25);
        r1.setFont(new Font("Baufra",Font.BOLD,12));
        r1.setBackground(Color.white);
        r1.setFocusable(false);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(270,160,200,25);
        r2.setFont(new Font("Baufra",Font.BOLD,12));
        r2.setBackground(Color.white);
        r2.setFocusable(false);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(40,190,150,25);
        r3.setFont(new Font("Baufra",Font.BOLD,12));
        r3.setBackground(Color.white);
        r3.setFocusable(false);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(270,190,230,25);
        r4.setFont(new Font("Baufra",Font.BOLD,12));
        r4.setBackground(Color.white);
        r4.setFocusable(false);
        add(r4);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);


        // Card Number Label

        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(40,240,150,30);
        cardNumberLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(cardNumberLabel);

        cardNumberPinLabel = new JLabel("XXXX-XXXX-XXXX-3423");
        cardNumberPinLabel.setBounds(250,240,250,30);
        cardNumberPinLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(cardNumberPinLabel);

        JLabel l1 = new JLabel("Your 16 digit card number");
        l1.setBounds(40,265,150,20);
        l1.setFont(new Font("Baufra",Font.BOLD,10));
        add(l1);


        // PIN label

        pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(40,305,150,30);
        pinLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(pinLabel);

        pinNumberLabel = new JLabel("XXXX");
        pinNumberLabel.setBounds(250,305,250,30);
        pinNumberLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(pinNumberLabel);

        JLabel l2 = new JLabel("Your 4 digit PIN number");
        l2.setBounds(40,330,150,20);
        l2.setFont(new Font("Baufra",Font.BOLD,10));
        add(l2);


        // Services Required Label

        servicesRequiredLabel = new JLabel("Services Required");
        servicesRequiredLabel.setBounds(40,380,200,30);
        servicesRequiredLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(servicesRequiredLabel);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(40,415,150,25);
        c1.setFont(new Font("Baufra",Font.BOLD,13));
        c1.setBackground(Color.white);
        c1.setFocusable(false);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(270,415,150,25);
        c2.setFont(new Font("Baufra",Font.BOLD,13));
        c2.setBackground(Color.white);
        c2.setFocusable(false);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(40,445,150,25);
        c3.setFont(new Font("Baufra",Font.BOLD,13));
        c3.setBackground(Color.white);
        c3.setFocusable(false);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBounds(270,445,200,25);
        c4.setFont(new Font("Baufra",Font.BOLD,13));
        c4.setBackground(Color.white);
        c4.setFocusable(false);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(40,475,150,25);
        c5.setFont(new Font("Baufra",Font.BOLD,13));
        c5.setBackground(Color.white);
        c5.setFocusable(false);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(270,475,200,25);
        c6.setFont(new Font("Baufra",Font.BOLD,13));
        c6.setBackground(Color.white);
        c6.setFocusable(false);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct");
        c7.setBounds(40,530,500,25);
        c7.setFont(new Font("Baufra",Font.BOLD,13));
        c7.setBackground(Color.white);
        c7.setFocusable(false);
        add(c7);


        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(170,575,100,35);
        submitButton.setFont(new Font("Railway",Font.BOLD,15));
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        add(submitButton);


        // Cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(330,575,100,35);
        cancelButton.setFont(new Font("Railway",Font.BOLD,15));
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        add(cancelButton);






        setSize(600,700);
        setLocation(400,50);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton){

            String accountType = "";
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if (r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 4089100300000000L);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);


            String facilities = "";
            if (c1.isSelected()){
                facilities += " ATM Card";
            }
            if (c2.isSelected()){
                facilities += " Internet Banking";
            }
            if(c3.isSelected()){
                facilities += " Mobile Banking";
            }
            if (c4.isSelected()){
                facilities += " EMAIL and SMS Alerts";
            }
            if(c5.isSelected()){
                facilities += " Cheque Book ";
            }
            if(c6.isSelected()){
                facilities += " E-Statement";
            }



            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                } else if (facilities.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select facilities");
                } else if (!(c7.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Please check if your filled data are correct");
                } else {

                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facilities+"')";
                    c.s.executeUpdate(query1);

                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Your card number: " + cardNumber + "\nYour pin: " + pinNumber);
                    setVisible(false);
                    new deposit(pinNumber).setVisible(true);

                }

            } catch (Exception e3){
                System.out.println(e);
            }

        } else if (e.getSource() == cancelButton) {

            setVisible(false);
            new login().setVisible(true);

        }
    }


    public static void main(String[] args) {
        new signupThree("");
    }


}
