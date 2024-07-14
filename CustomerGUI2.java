/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author Themar yassir
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerGUI2 extends JFrame {
    
    //initialise the components for the jfram
    private ArrayList<Customer1> data = new ArrayList<>();
    private JTextField nameField, phoneNumberField, dateField;
    private JTextArea displayArea;
    private JLabel message = new JLabel("Please enter your data");
    private JLabel nameLabel = new JLabel("           Name:");
    private JLabel phoneLabel = new JLabel("Phone Number:");
    private JLabel dateLabel = new JLabel("Date:");
    private JButton nextButton;
    
    //constructor
    public CustomerGUI2() {
        setTitle("Customer Data GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 400);
        setLocationRelativeTo(null);
        
        nameField = new JTextField(12);
        phoneNumberField = new JTextField(12);
        dateField = new JTextField(12);
        JButton addButton = new JButton("Add Customer");
        nextButton = new JButton("Next");
       //change the color and the size of the text 
        Font fieldFont = new Font("Arial", Font.BOLD, 14);
        nameField.setFont(fieldFont);
        message.setForeground(Color.blue);
        phoneNumberField.setFont(fieldFont);
        dateField.setFont(fieldFont);
        message.setFont(fieldFont);
        nameLabel.setFont(fieldFont);
        phoneLabel.setFont(fieldFont);
        dateLabel.setFont(fieldFont);
        addButton.setFont(fieldFont);
        nextButton.setFont(fieldFont);
        
        
        displayArea = new JTextArea(25, 25);
        displayArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        JPanel inputPanel2 = new JPanel();
        inputPanel.setBackground(Color.pink);
        inputPanel2.setBackground(Color.pink);
        
        // add the components to the panel and content pane
        inputPanel.add(message);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneNumberField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(addButton);
        inputPanel2.add(nextButton);
 
        JScrollPane scrollPane = new JScrollPane(displayArea);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(inputPanel2, BorderLayout.SOUTH);
        container.add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
        
        //add Action listener for the button add

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });
        
        //add Action listener for the button next
       nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
                openNextWindow();
            }
        });
    }
//method 1
   private void openNextWindow() {
        
    TableGUI tab=new TableGUI();
    tab.setVisible(true);

     
    }
   
   //method 2 to add exception
    private void addCustomer() {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String date = dateField.getText();

        if (name.trim().isEmpty() || phoneNumber.trim().isEmpty() || date.trim().isEmpty()) {
            displayArea.append("Invalid Entries\n");
            return;
        }

        try {
            if (isValidPhoneNumber(phoneNumber)) {
                Customer1 customer = new Customer1(name, phoneNumber, date);
                data.add(customer);
                displayArea.append(customer.toString() + "\n");

                // Clear the input fields
                nameField.setText("");
                phoneNumberField.setText("");
                dateField.setText("");
            } else {
                throw new InvalidPhoneNumberException();
            }
        } catch (InvalidPhoneNumberException e) {
            displayArea.append(e.getMessage() + "\n");
        }
    }
//method to add exception for the phone number
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Simple validation: Check if the phone number is a 10-digit numeric value
        return phoneNumber.matches("\\d{10}");
    }
// class to write tostring
    public static class Customer1 {
        private String name;
        private String phoneNumber;
        private String date;

        public Customer1(String name, String phoneNumber, String date) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.date = date;
        }

        public String toString() {
            return "Customer Details:\nName: " + this.name + "\nPhone Number: " + this.phoneNumber + "\nDate: " + this.date + "\n\n";
        }
    }

   
    }

