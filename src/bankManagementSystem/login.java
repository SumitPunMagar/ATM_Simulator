package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {

    JLabel logoLabel;
    JLabel heading;
    JLabel cardNumber;
    JLabel pin;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    JButton signInButton;
    JButton clearButton;
    JButton signUpButton;



    // constructor
    login(){

        // Logo

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image image2 = image1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);

        logoLabel = new JLabel(new ImageIcon(image2));
        logoLabel.setBounds(50,30,80,80);
        add(logoLabel);

        // Heading
        heading = new JLabel("Welcome to ATM");
        heading.setBounds(180,30,300,80);
        heading.setFont(new Font("Baufra",Font.BOLD,30));
        add(heading);

        // Card label and card TextField
        cardNumber = new JLabel("Card No :");
        cardNumber.setBounds(50,150,150,40);
        cardNumber.setFont(new Font("Belleza",Font.BOLD,18));
        add(cardNumber);

        cardTextField = new JTextField();
        cardTextField.setBounds(200,150,300,40);
        cardTextField.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(cardTextField);

        // Pin label and pin text field

        pin = new JLabel("PIN :");
        pin.setBounds(50,220,150,40);
        pin.setFont(new Font("Belleza",Font.BOLD,18));
        add(pin);

        pinPasswordField = new JPasswordField();
        pinPasswordField.setBounds(200,220,300,40);
        pinPasswordField.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add(pinPasswordField);

       

        // Sign Up button
        signInButton = new JButton("Sign In");
        signInButton.setBounds(200,300,120,40);
        signInButton.setFont(new Font("Railway",Font.BOLD,15));
        signInButton.setFocusable(false);
        add(signInButton);
        signInButton.addActionListener(this);

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(380,300,120,40);
        clearButton.setFont(new Font("Railway",Font.BOLD,15));
        clearButton.setFocusable(false);
        add(clearButton);
        clearButton.addActionListener(this);

        // Sign in button
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200,360,300,40);
        signUpButton.setFont(new Font("Raleway",Font.BOLD,15));
        signUpButton.setFocusable(false);
        add(signUpButton);
        signUpButton.addActionListener(this);





        setSize(580,500);
        setLocation(400,120);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearButton){
            cardTextField.setText("");
            pinPasswordField.setText("");
        } else if (e.getSource() == signUpButton) {

            setVisible(false);
            new signupOne().setVisible(true);

        } else if (e.getSource() == signInButton) {

            String cardNumber = cardTextField.getText();
            String pinNumber = pinPasswordField.getText();

            Conn c = new Conn();
            String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new transaction(pinNumber).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }

    public static void main(String[] args) {
        new login();
    }

}
