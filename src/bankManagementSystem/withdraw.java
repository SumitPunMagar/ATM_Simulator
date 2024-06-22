package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {

    JLabel text;
    JTextField amountWithdraw;
    JButton withdraw, back;
    String pinNumber;


    // constructor
    withdraw(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/ATM-Machine.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel atmbackground = new JLabel(image3);
        atmbackground.setBounds(0,0,1000,600);
        add(atmbackground);

        // text

        text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(309,295,260,20);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(text);

        // amount deposit text field

        amountWithdraw = new JTextField();
        amountWithdraw.setBounds(315,320,243,20);
        amountWithdraw.setForeground(Color.black);
        amountWithdraw.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(amountWithdraw);

        // balance enquiry button
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(458,369,100,20);
        withdraw.setFont(new Font("Raleway",Font.BOLD,10));
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);
        atmbackground.add(withdraw);

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
        if (e.getSource() == withdraw){
            String amount = amountWithdraw.getText();
            Date date = new Date();

            if (amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            } else {

                try{

                Conn c = new Conn();
                int balance = 0;
                ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinNumber+"'");

                while (rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!!");
                } else {

                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'withdraw', '" + amount + "')";


                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "You successfully withdraw Rs " + amount + " from your bank account");
                    setVisible(false);
                    new transaction(pinNumber).setVisible(true);

                }

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

        new withdraw("");
    }
}

