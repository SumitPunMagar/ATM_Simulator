package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

public class fastCash extends JFrame implements ActionListener {


    JLabel text;
    JButton b1, b2, b3, b4, b5, b6, back;

    String pinNumber;

    // constructor
    fastCash(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/ATM-Machine.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel atmbackground = new JLabel(image3);
        atmbackground.setBounds(0,0,1000,600);
        add(atmbackground);


        text = new JLabel("Please select your amount");
        text.setBounds(360,300,200,20);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 9));
        atmbackground.add(text);


        // deposit button
        b1 = new JButton("Rs 500");
        b1.setBounds(303,325,128,20);
        b1.setFont(new Font("Raleway",Font.BOLD,10));
        b1.setFocusable(false);
        b1.addActionListener(this);
        atmbackground.add(b1);

        // cash withdrawal button
        b2 = new JButton("Rs 1000");
        b2.setBounds(438,325,128,20);
        b2.setFont(new Font("Raleway",Font.BOLD,10));
        b2.setFocusable(false);
        b2.addActionListener(this);
        atmbackground.add(b2);

        // fast cash button
        b3 = new JButton("Rs 3000");
        b3.setBounds(303,347,128,20);
        b3.setFont(new Font("Raleway",Font.BOLD,10));
        b3.setFocusable(false);
        b3.addActionListener(this);
        atmbackground.add(b3);

        // Mini Statement button
        b4 = new JButton("Rs 5000");
        b4.setBounds(438,347,128,20);
        b4.setFont(new Font("Raleway",Font.BOLD,10));
        b4.setFocusable(false);
        b4.addActionListener(this);
        atmbackground.add(b4);


        // pin change button
        b5 = new JButton("Rs 7000");
        b5.setBounds(303,369,128,20);
        b5.setFont(new Font("Raleway",Font.BOLD,10));
        b5.setFocusable(false);
        b5.addActionListener(this);
        atmbackground.add(b5);

        // balance enquiry button
        b6 = new JButton("Rs 10000");
        b6.setBounds(438,369,128,20);
        b6.setFont(new Font("Raleway",Font.BOLD,10));
        b6.setFocusable(false);
        b6.addActionListener(this);
        atmbackground.add(b6);

        // exit button
        back = new JButton("Back");
        back.setBounds(438,391,128,20);
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
        if (e.getSource() == back){

            setVisible(false);
            new transaction(pinNumber).setVisible(true);
        } else {

            String amount = ((JButton)e.getSource()).getText().substring(3);

            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinNumber+"'");
                int balance = 0;

                while (rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!!");

                }
                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'withdraw', '"+amount+"')";

                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "You successfully withdraw Rs " + amount + " from your bank account");
                        setVisible(false);
                        new transaction(pinNumber).setVisible(true);


            } catch (Exception fce){
                System.out.println(fce);
            }

        }

    }

    public static void main(String[] args){
        new fastCash("");

    }
}
