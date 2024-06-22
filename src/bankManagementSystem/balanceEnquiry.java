package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class balanceEnquiry extends JFrame implements ActionListener {

    String pinNumber;

    JButton back;

    JLabel currentBalanceLabel;

    // constructor
    balanceEnquiry(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/ATM-Machine.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel atmbackground = new JLabel(image3);
        atmbackground.setBounds(0,0,1000,600);
        add(atmbackground);



        // back button
        back = new JButton("Back");
        back.setBounds(468,383,80,22);
        back.setFont(new Font("Raleway",Font.BOLD,12));
        back.setFocusable(false);
        back.addActionListener(this);
        atmbackground.add(back);

        int balance = 0;

        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinNumber+"'");

            while (rs.next()){
                if (rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception fce){
            System.out.println(fce);
        }


        // current balance label

        currentBalanceLabel = new JLabel("Your current balance is RS " + balance);
        currentBalanceLabel.setBounds(312,312,300,20);
        currentBalanceLabel.setForeground(Color.black);
        currentBalanceLabel.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(currentBalanceLabel);



        setSize(1000,600);
        setLocation(200,80);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        setVisible(false);
        new transaction(pinNumber).setVisible(true);

    }


    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
