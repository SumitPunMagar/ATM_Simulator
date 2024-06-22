package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class deposit extends JFrame implements ActionListener{

    JLabel text;
    JTextField amountDeposit;
    JButton deposit, back;
    String pinNumber;


    // constructor
    deposit(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/ATM-Machine.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel atmbackground = new JLabel(image3);
        atmbackground.setBounds(0,0,1000,600);
        add(atmbackground);

        // text

        text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(315,295,250,20);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(text);

        // amount deposit text field

        amountDeposit = new JTextField();
        amountDeposit.setBounds(315,320,243,20);
        amountDeposit.setForeground(Color.black);
        amountDeposit.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(amountDeposit);

        // balance enquiry button
        deposit = new JButton("Deposit");
        deposit.setBounds(458,369,100,20);
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setFocusable(false);
        deposit.addActionListener(this);
        atmbackground.add(deposit);

        // exit button
        back = new JButton("Back");
        back.setBounds(458,391,100,20);
        back.setFont(new Font("Raleway",Font.BOLD,10));
        back.setFocusable(false);
        back.addActionListener(this);
        atmbackground.add(back);



        setSize(1000,600);
        setLocation(200,80);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == deposit){
            String amount = amountDeposit.getText();
            Date date = new Date();

            if (amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                Conn c = new Conn();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'deposit', '"+amount+"')";

                try{
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "You successfully deposit Rs " + amount + " on your bank account");
                    setVisible(false);
                    new transaction(pinNumber).setVisible(true);

                } catch (Exception ed){
                    System.out.println(ed);
                }

            }


        } else if(e.getSource() == back){
            setVisible(false);
            new transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {

        new deposit("");
    }
}
