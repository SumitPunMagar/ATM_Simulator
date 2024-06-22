package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {

    JLabel text, newPinLabel, confirmNewPinLabel;

    JPasswordField newPinField, confirmNewPinField;

    JButton change, back;

    String pinNumber;

    // constructor
    pinChange(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/ATM-Machine.jpg"));
        Image image2 = image1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel atmbackground = new JLabel(image3);
        atmbackground.setBounds(0,0,1000,600);
        add(atmbackground);

        // text
        text = new JLabel("Change your pin");
        text.setBounds(360,295,200,20);
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 15));
        atmbackground.add(text);


        // new pin label
        newPinLabel = new JLabel("New Pin: ");
        newPinLabel.setBounds(308,320,150,20);
        newPinLabel.setForeground(Color.black);
        newPinLabel.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(newPinLabel);

        // new pin password field
        newPinField = new JPasswordField();
        newPinField.setBounds(435,320,120,20);
        newPinField.setForeground(Color.black);
        newPinField.setFont(new Font("System", Font.BOLD, 12));
        atmbackground.add(newPinField);


        // confirm new pin label
        confirmNewPinLabel = new JLabel("Confirm New Pin: ");
        confirmNewPinLabel.setBounds(308,343,150,20);
        confirmNewPinLabel.setForeground(Color.black);
        confirmNewPinLabel.setFont(new Font("System", Font.BOLD, 11));
        atmbackground.add(confirmNewPinLabel);

        // new pin password field
        confirmNewPinField = new JPasswordField();
        confirmNewPinField.setBounds(435,343,120,20);
        confirmNewPinField.setForeground(Color.black);
        confirmNewPinField.setFont(new Font("System", Font.BOLD, 12));
        atmbackground.add(confirmNewPinField);


        // change button
        change = new JButton("Change");
        change.setBounds(350,386,80,20);
        change.setFont(new Font("Raleway",Font.BOLD,10));
        change.setFocusable(false);
        change.addActionListener(this);
        atmbackground.add(change);

        // back button
        back = new JButton("Back");
        back.setBounds(448,386,80,20);
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

        if (e.getSource() == back ){
            setVisible(false);
            new transaction(pinNumber).setVisible(true);
        } else {
            String newPin = newPinField.getText();
            String confirmPin = confirmNewPinField.getText();

            if (!newPin.equals(confirmPin)){
                JOptionPane.showMessageDialog(null, "Your new pin and confirm new pin doesn't match");
            }

            if (newPin.equals("") || confirmPin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter password to change");
            }


            try {
                Conn c = new Conn();
                String query1 = "update signupthree set pin_number = '"+newPin+"' where pin_number = '"+pinNumber+"'";
                String query2 = "update login set pin_number = '"+newPin+"' where pin_number = '"+pinNumber+"'";
                String query3 = "update bank set pin_number = '"+newPin+"' where pin_number = '"+pinNumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin changed successfully");
                setVisible(false);
                new transaction(newPin).setVisible(true);

            } catch (Exception pe){
                System.out.println(pe);
            }




        }

    }

    public static void main(String[] args) {
        new pinChange("");
    }
}
