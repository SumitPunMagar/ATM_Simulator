package bankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class signupOne extends JFrame implements ActionListener {

    JLabel formLabel;
    JLabel detailLabel;
    JLabel name, fatherName, DOB, gender, email, maritalStatus, address, city, state, pincode;

    JTextField nameField, fNameField, emailField, addressField, cityField, stateField, pincodeField;

    JDateChooser dateChooser;
    JRadioButton male, female, other;
    JRadioButton married, unmarried, otherStatus;

    JButton nextButton;
    long formNumber;

    // constructor
    signupOne(){

        // Form label

        Random random = new Random();
        formNumber = Math.abs((random.nextLong() % 9000L) + 1000L);

        formLabel = new JLabel("Application Form No. " + formNumber);
        formLabel.setBounds(90,5,400,50);
        formLabel.setFont(new Font("Baufra",Font.BOLD,25));
        add(formLabel);

        // Details label

        detailLabel = new JLabel("Page 1: Personal Details");
        detailLabel.setBounds(160,55,300,30);
        detailLabel.setFont(new Font("Baufra",Font.BOLD,18));
        add(detailLabel);

        // Name

        name = new JLabel("Name:");
        name.setBounds(40,120,100,30);
        name.setFont(new Font("Baufra",Font.BOLD,16));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(200,120,300,30);
        nameField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(nameField);

        // father name

        fatherName = new JLabel("Father's Name:");
        fatherName.setBounds(40,155,150,30);
        fatherName.setFont(new Font("Baufra",Font.BOLD,16));
        add(fatherName);

        fNameField = new JTextField();
        fNameField.setBounds(200,155,300,30);
        fNameField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(fNameField);

        // date of birth

        DOB = new JLabel("Date of Birth:");
        DOB.setBounds(40,195,150,30);
        DOB.setFont(new Font("Baufra",Font.BOLD,16));
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(200, 195,300,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

        // Gender

        gender = new JLabel("Gender:");
        gender.setBounds(40,230,150,30);
        gender.setFont(new Font("Baufra",Font.BOLD,16));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200,230,100,30);
        male.setFocusable(false);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(315,230,100,30);
        female.setBackground(Color.white);
        female.setFocusable(false);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(437,230,100,30);
        other.setBackground(Color.white);
        other.setFocusable(false);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        // Email address

        email = new JLabel("Email:");
        email.setBounds(40,265,150,30);
        email.setFont(new Font("Baufra",Font.BOLD,16));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(200,265,300,30);
        emailField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(emailField);


        // Marital Status

        maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setBounds(40,300,150,30);
        maritalStatus.setFont(new Font("Baufra",Font.BOLD,16));
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(200,300,100,30);
        married.setFocusable(false);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(315,300,100,30);
        unmarried.setBackground(Color.white);
        unmarried.setFocusable(false);
        add(unmarried);

        otherStatus = new JRadioButton("Other");
        otherStatus.setBounds(437,300,100,30);
        otherStatus.setBackground(Color.white);
        otherStatus.setFocusable(false);
        add(otherStatus);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(married);
        statusGroup.add(unmarried);
        statusGroup.add(otherStatus);

        // Address

        address = new JLabel("Address:");
        address.setBounds(40,335,150,30);
        address.setFont(new Font("Baufra",Font.BOLD,16));
        add(address);

        addressField = new JTextField();
        addressField.setBounds(200,335,300,30);
        addressField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(addressField);

        // City

        city = new JLabel("City:");
        city.setBounds(40,370,150,30);
        city.setFont(new Font("Baufra",Font.BOLD,16));
        add(city);

        cityField = new JTextField();
        cityField.setBounds(200,370,300,30);
        cityField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(cityField);


        // State

        state = new JLabel("State:");
        state.setBounds(40,405,150,30);
        state.setFont(new Font("Baufra",Font.BOLD,16));
        add(state);

        stateField = new JTextField();
        stateField.setBounds(200,405,300,30);
        stateField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(stateField);


        // Pin code

        pincode = new JLabel("Pincode:");
        pincode.setBounds(40,440,150,30);
        pincode.setFont(new Font("Baufra",Font.BOLD,16));
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setBounds(200,440,300,30);
        pincodeField.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(pincodeField);

        // Next Button

        nextButton = new JButton("Next");
        nextButton.setBounds(400,500,100,30);
        nextButton.setFont(new Font("Railway",Font.BOLD,15));
        nextButton.setFocusable(false);
        nextButton.addActionListener(this);
        add(nextButton);






        setSize(545,620);
        setLocation(400,50);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + formNumber;
        String name = nameField.getText();
        String fname = fNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pincode = pincodeField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }


        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (otherStatus.isSelected()) {
            marital = "Other";
        }


        try{
            // form validation
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "name is required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's name is required");
            }else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "DOB is required");
            }else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Gender is required");
            }else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is required");
            }else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Marital state is required");
            }else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required");
            }else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City's name is required");
            }else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State's name is required");
            }else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is required");
            }else {
                // creating instance of Conn
                Conn c = new Conn();

                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"','"+state+"', '"+pincode+"')";

                c.s.executeUpdate(query);

                // after clicking next button signupTwo will appear
                setVisible(false);
                new signupTwo(formno).setVisible(true);

            }

        } catch (Exception e1){
            System.out.println(e1);
        }



    }


    public static void main(String[] args) {
        new signupOne();
    }

}
