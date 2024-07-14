/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;
import java.awt.*;
import static java.awt.Color.PINK;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Themar yassir
 */
public class Receipt extends JFrame {
    private JButton buto=new JButton("Show Receipt");
    private JPanel pan=new JPanel();
    private JLabel la;
    private JTextArea rArea;
    private ImageIcon imag;
    
    public Receipt(){
       setTitle("Receipt");
        // Set the size of this window.
        setSize(450, 370);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //add button into action listener
        buto.addActionListener(new buevevnt());
        
         rArea = new JTextArea(4, 3);
        rArea.setEditable(false);
        imag=new ImageIcon("re.gif");
        la=new JLabel(imag);
        pan.setBackground(PINK);
        buto.setFont(new Font("Serif",Font.BOLD,15));
        pan.add(buto);
        add(la,BorderLayout.CENTER);
        add(pan,BorderLayout.NORTH);
       add(rArea,BorderLayout.SOUTH);

        setVisible(true);
    }
    
     private class buevevnt implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            
       try{
           
           String line="";
           File f=new File("receipt.txt");
           Scanner s=new Scanner(f);
        while (s.hasNextLine()){
          line+=s.nextLine()+"\n";
          rArea.setText(line);
       }
       }
       catch (IOException g){
           g.printStackTrace();
           
       }
        
       
        }
        }
    
     
    }

   
