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
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableGUI extends JFrame {
    //initialise the components for the jfram 
    private JTextField tableNumberField;
    private JTextArea resultArea;
    private JRadioButton indoorRadioButton = new JRadioButton("Indoor");
    private JRadioButton outdoorRadioButton = new JRadioButton("Outdoor");
    private JButton pButton;
    private ButtonGroup locationButtonGroup = new ButtonGroup();
    private static final double RESERVATION_FEE = 10.0;
//constructor
    public TableGUI() {
        setTitle("Table Information");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setBackground(Color.pink);
        
        JLabel tableNumberLabel = new JLabel("Number of tables:");
        tableNumberField = new JTextField(10);

        JLabel locationLabel = new JLabel("Location:");

        pButton = new JButton("Next");
        

        locationButtonGroup.add(indoorRadioButton);
        locationButtonGroup.add(outdoorRadioButton);
        
//change the color and the size of the text

        Font fieldFont = new Font("Arial", Font.BOLD, 14);
        tableNumberLabel.setFont(fieldFont);
        tableNumberField.setFont(fieldFont);
        locationLabel.setFont(fieldFont);
        pButton.setFont(fieldFont);
        indoorRadioButton.setFont(fieldFont);
        outdoorRadioButton.setFont(fieldFont);
       
        
//add Action listener for the button save

        pButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTableInfo();
            }
        });

        resultArea = new JTextArea(9, 30);
        resultArea.setEditable(false);
        
      // add the components to the panel and content pane using FlowLayout
       setLayout(new FlowLayout());

        panel.add(tableNumberLabel);
        panel.add(tableNumberField);
        panel.add(locationLabel);
        panel.add(indoorRadioButton);
        panel.add(outdoorRadioButton);
        panel.add(pButton);
        add(panel);
        add(resultArea);
       super.setVisible(true);
    }
//method 1 add exception for invalid table input
    private void updateTableInfo() {
        try {
            int tableNumber = Integer.parseInt(tableNumberField.getText());

            String location = "";
            if (indoorRadioButton.isSelected()) {
                location = "Indoor";
            } else if (outdoorRadioButton.isSelected()) {
                location = "Outdoor";
            } else {
                throw new InvalidTableLocationException();
            }

            // Calculate the reservation fee
            double fee = calculateReservationFee();

            String data = "Table Number: " + tableNumber + "\nLocation: " + location ;
           
            // call the Write method to write data to file
            writetofile(data,fee);
             Receipt re=new Receipt();
                re.setVisible(true);
           
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid input. Please enter a valid table number.");
        } catch (InvalidTableLocationException e) {
            resultArea.setText(e.getMessage());
        }
    }
//method 2 to calaculate the reservation fee
    private double calculateReservationFee() {
       double x;
       x= RESERVATION_FEE * Integer.parseInt(tableNumberField.getText()); ;
        
       return x;
                
    }
    //method 3 to write data in file 
    public void writetofile(String s,double e){
        try{
     File file=new File("receipt.txt");
     
     if (!file.exists()){
          file.createNewFile();
     }
     PrintWriter pw=new PrintWriter(file);
     pw.println(s);
     pw.println( "ReservationFee: "+ e + " SR");
     pw.close();

     System.out.println("writen sucssfuly");
     
     } 
    catch (IOException ex) {
             Logger.getLogger(TableGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
  

    
  
}
// exception for invalid table location
class InvalidTableLocationException extends Exception {
    public InvalidTableLocationException() {
        super("Invalid table location. Please select a valid location (Indoor or Outdoor).");
    }
}