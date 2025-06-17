/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

import javax.swing.JOptionPane;

public class Login {
    Registration regObj = new Registration ();
    
     private String username;
    private String password;
    private String cellNumber;
    private String firstName;
    private String lastName;
    
     //Message for correct password format 
    String passMessage = "Password is successfully captured";
    
    //Message for correct username format 
    String nameMessage = "Username is successfully captured";
    
    //Message for correct cell phone number message
    String cellMessage = "Cell phone number successfully captured";
   
   


    
      // Temporary variables for login check
    private String storedUsername;
    private String storedPassword;
    private String storedFirstname;
    private String storedLastName;

    public Login(String name, String srname) {
        this.firstName = name;
        this.lastName = srname;
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // Password must be at least 8 chars, 1 capital, 1 number, 1 special char
         boolean passwordOkay = false;
        boolean hasNumber = false;
        boolean hasCap = false;
        boolean hasChar = false;
        char current;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                current = password.charAt(i);
                
                
                if (Character.isUpperCase(current)){ 
                    hasCap = true;
                }
                if (Character.isDigit(current)){ 
                    hasNumber = true;
                }
                if (! (Character.isLetterOrDigit(current)) ){ 
                    hasChar = true;
                }
            }
            if (hasNumber && hasCap && hasChar){
                passwordOkay = true;
            }
            return passwordOkay;
    }
         return false;
    }

    public boolean checkCellPhoneNumber(String number) {
        // ChatGPT regex reference: Check international format and ≤ 10 digits
        String regex = "^\\+\\d{11,13}$"; // e.g. +27831234567
        return number.matches(regex);
    }

    public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
        StringBuilder message = new StringBuilder();
        this.firstName = firstName;
        this.lastName = lastName;
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        message.append("Username successfully captured.\n");
        
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        message.append("Password successfully captured.\n");
        
        
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
            
        }
        message.append("Cellphone number successfully captured.\n");
        

        // Store the credentials
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;
        this.storedUsername = username;
        this.storedPassword = password;

       
        JOptionPane.showMessageDialog(null, message.toString());
        return "Registration successful.";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + this.firstName + " " + this.lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
            
        }
    }
    
}



