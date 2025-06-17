/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registration;

import javax.swing.JOptionPane;



public class Registration {
    private static String userName;
    private static String password;
    private static String cellNumber;
    private static String firstName;
    private static String lastName;
    
     public static void setFirstName(String name) {
        firstName = name;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setUserName(String username) {
        userName = username;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setPassword(String pass) {
        password = pass;
    }

    public static String getPassword() {
        return password;
        
        }

    public static void setLastname(String srname) {
        lastName = srname;
    }

    public static String getLastname() {
        return lastName;
        
    }
    
    public static void setCellNumber(String cellnumber){
        cellNumber = cellnumber;
    }
    
    public static String getCellNumber(){
        return cellNumber;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Registration regObj = new Registration ();
         Login login = new Login(firstName, lastName);
         
         JOptionPane.showMessageDialog(null,"**Registration**");
        
        firstName =JOptionPane.showInputDialog(" Please enter your first name");
        lastName =JOptionPane.showInputDialog("Please enter your lastname");
        userName =JOptionPane.showInputDialog("Enter your user name. (Note: User name must be less than 5 characteristics long and contain an underscore)");
        password =JOptionPane.showInputDialog("Create a password. Note: Password must contain at least 8 characters, a capital letter, a number and l character.");
        cellNumber =JOptionPane.showInputDialog("Please enter cellphone number with country code");
        
        String regStatus = login.registerUser(userName, password, cellNumber, firstName, lastName);
        JOptionPane.showMessageDialog(null, regStatus);
        
           if (regStatus.equals("Registration successful.")){
               JOptionPane.showMessageDialog(null,"**Login**" );
               String loginUser = JOptionPane.showInputDialog("Enter your username. (Note: User name must be less than 5 characteristics long and contain an underscore)");
               String loginPass = JOptionPane.showInputDialog("Enter password");
               
                String loginStatus = login.returnLoginStatus(loginUser, loginPass);
                JOptionPane.showMessageDialog(null, loginStatus);
                
                if(loginStatus.startsWith("Welcome")){
                    QuickChat quickChat = new QuickChat();
                    quickChat.start();
                }
           }

        
        
    }
    
}
