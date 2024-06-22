package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class transaction extends JFrame implements ActionListener {


    JLabel text;
    JButton deposit, cashWithdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;

    String pinNumber;

    // constructor
    transaction(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/ATM-Machine.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel atmbackground = new JLabel(image3);
        atmbackground.setBounds(0,0,1000,600);
        add(atmbackground);


        text = new JLabel("Please select your Transaction");
        text.setBounds(360,300,200,20);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 9));
        atmbackground.add(text);


        // deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(303,325,128,20);
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setFocusable(false);
        deposit.addActionListener(this);
        atmbackground.add(deposit);

        // cash withdrawal button
        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(438,325,128,20);
        cashWithdrawal.setFont(new Font("Raleway",Font.BOLD,10));
        cashWithdrawal.setFocusable(false);
        cashWithdrawal.addActionListener(this);
        atmbackground.add(cashWithdrawal);

        // fast cash button
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(303,347,128,20);
        fastCash.setFont(new Font("Raleway",Font.BOLD,10));
        fastCash.setFocusable(false);
        fastCash.addActionListener(this);
        atmbackground.add(fastCash);

        // Mini Statement button
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(438,347,128,20);
        miniStatement.setFont(new Font("Raleway",Font.BOLD,10));
        miniStatement.setFocusable(false);
        miniStatement.addActionListener(this);
        atmbackground.add(miniStatement);


        // pin change button
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(303,369,128,20);
        pinChange.setFont(new Font("Raleway",Font.BOLD,10));
        pinChange.setFocusable(false);
        pinChange.addActionListener(this);
        atmbackground.add(pinChange);

        // balance enquiry button
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(438,369,128,20);
        balanceEnquiry.setFont(new Font("Raleway",Font.BOLD,10));
        balanceEnquiry.setFocusable(false);
        balanceEnquiry.addActionListener(this);
        atmbackground.add(balanceEnquiry);

        // exit button
        exit = new JButton("Exit");
        exit.setBounds(438,391,128,20);
        exit.setFont(new Font("Raleway",Font.BOLD,10));
        exit.setFocusable(false);
        exit.addActionListener(this);
        atmbackground.add(exit);




        setSize(1000,600);
        setLocation(200,80);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == deposit){
            setVisible(false);
            new deposit(pinNumber).setVisible(true);
        } else if (e.getSource() == cashWithdrawal) {
            setVisible(false);
            new withdraw(pinNumber).setVisible(true);
        } else if (e.getSource() == fastCash) {
            setVisible(false);
            new fastCash(pinNumber).setVisible(true);
        } else if (e.getSource() == pinChange) {
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        } else if (e.getSource() == balanceEnquiry){
            setVisible(false);
            new balanceEnquiry(pinNumber).setVisible(true);
        } else if (e.getSource() == miniStatement) {
            new miniStatement(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args){
        new transaction("");

    }
}
