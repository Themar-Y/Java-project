/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menu;
import java.awt.*;
import static java.awt.Color.PINK;
import static java.awt.Color.blue;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Themar yassir
 */
public class Menu extends JFrame {

    //initialise the components for the jfram
    private JMenuBar bar=new JMenuBar();
    private JMenu file=new JMenu("File");
    private JMenu rest=new JMenu("Restaurants");
    private JMenuItem exit=new JMenuItem("Exit");
    private JRadioButton b1=new JRadioButton("Blue Ocean restaurant");
    private JRadioButton b2=new JRadioButton("Five Guys restaurant");
    private JRadioButton b3=new JRadioButton("Shake Shack restaurant");
    private JLabel text=new  JLabel("Choose one restaurant from the menu above  : ");
    JPanel pan=new JPanel();
    ImageIcon im;
    JLabel photo;
    
    //constructor
    public Menu(){
       setTitle("Menu");

        // Set the size of this window.
        setSize(620, 440);
        pan.setBackground(PINK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pan.add(text);
        text.setFont(new Font("Serif",Font.BOLD,18));
        text.setForeground(blue);
        im=new ImageIcon("pho.gif");
        photo=new JLabel("*** Welcome to our reservation App ***",im,SwingConstants.CENTER);
        photo.setFont(new Font("Serif",Font.BOLD,19));
        //add Action listener for exit
        exit.addActionListener(new exitevent());
        //add exite menu item to the menu
        file.add(exit);
        //add action listener to the radiobuttons 
        b1.addActionListener(new jraddioevevnt());
        b2.addActionListener(new jraddioevevnt());
        b3.addActionListener(new jraddioevevnt());
        //add the radiobutton to buttongroup
        ButtonGroup p=new ButtonGroup();
        p.add(b1);
        p.add(b2);
        p.add(b3);
        //add the radiobutton to the menu resturant
        rest.add(b1);
        rest.add(b2);
        rest.add(b3);
        //add the menus to the jmenu bar
        bar.add(file);
        bar.add(rest);
        setJMenuBar(bar);
        //add the photo and the panel to the content pane using borderlayout
        add(photo,BorderLayout.CENTER);
        add(pan,BorderLayout.NORTH);
        
        setVisible(true);
    }
    //add Action listener for exit menuitem

    private class exitevent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);   
        }
        
    }
    //add Action listener for radiobutton 
    private class jraddioevevnt implements ActionListener{
        public void actionPerformed(ActionEvent e){
            CustomerGUI2 co=new CustomerGUI2() ;
            co.setVisible(true);
            
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       new Menu();
    }
    
}

