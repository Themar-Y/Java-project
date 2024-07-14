/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author Themar yassir
 */
public class InvalidPhoneNumberException extends Exception{
    public InvalidPhoneNumberException() {
        super("Invalid phone number. Please enter a valid 10-digit phone number.");
    }

    
}
