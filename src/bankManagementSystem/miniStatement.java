package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class miniStatement extends JFrame {

    String pinNumber;
    JLabel bankNameLabel, logoLabel, cardNumberLabel, miniStatement, displayBalance;

    // constructor
    miniStatement(String pinNumber){
        this.pinNumber = pinNumber;

        // bank name label
        bankNameLabel = new JLabel("Nepal Rastriya Bank");
        bankNameLabel.setBounds(80,35,200, 20);
        bankNameLabel.setFont(new Font("System",Font.BOLD,15));
        bankNameLabel.setForeground(Color.black);
        add(bankNameLabel);

        // NRB logo

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/nrbLogo.jpg"));
        Image image2 = image1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);

        logoLabel = new JLabel(new ImageIcon(image2));
        logoLabel.setBounds(280,5,80,80);
        add(logoLabel);


        // card number label
        cardNumberLabel = new JLabel();
        cardNumberLabel.setBounds(40,120,300, 20);
        cardNumberLabel.setFont(new Font("System",Font.BOLD,12));
        cardNumberLabel.setForeground(Color.black);
        add(cardNumberLabel);


        Conn c = new Conn();

        try {
            String query = "select * from login where pin_number = '"+pinNumber+"'";
            ResultSet cardNum = c.s.executeQuery(query);
            while (cardNum.next()){
                cardNumberLabel.setText("Card Number:  " + cardNum.getString("card_number").substring(0,4) + "XXXXXXXX" + cardNum.getString("card_number").substring(12));
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }



        // To display mini Statement

        miniStatement = new JLabel();
        miniStatement.setBounds(40,130,500, 300);
        miniStatement.setFont(new Font("System",Font.BOLD,12));
        miniStatement.setForeground(Color.black);
        add(miniStatement);

        int balance = 0;

        try {
            String query = "select * from bank where pin_number = '"+pinNumber+"'";
            ResultSet mini = c.s.executeQuery(query);

            while (mini.next()){
                miniStatement.setText( miniStatement.getText() + "<html>" + mini.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + mini.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + mini.getString("amount") + "<br><br><html>");
                if (mini.getString("type").equals("deposit")){
                    balance += Integer.parseInt(mini.getString("amount"));
                } else {
                    balance -= Integer.parseInt(mini.getString("amount"));
                }
            }
        } catch (Exception e2) {
            System.out.println(e2);
        }


        // to display balance
        displayBalance = new JLabel();
        displayBalance.setText("Your current balance is Rs " + balance);
        displayBalance.setBounds(40,450,300, 20);
        displayBalance.setFont(new Font("System",Font.BOLD,14));
        displayBalance.setForeground(Color.black);
        add(displayBalance);










        setSize(600,600);
        setLocation(20,40);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new miniStatement("");
    }
}
