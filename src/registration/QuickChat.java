/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;



public class QuickChat {
    private ArrayList<Message> sentMessages = new ArrayList<>();
    private int totalSent = 0;
    
    /**
     *
     */
    public void start() {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");
        
        
        
        int count= Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));
        
        for (int i=0; i< count; i++){
            String option = JOptionPane.showInputDialog("""
                                                        Menu:
                                                        1.Send Messages
                                                        2.Coming Soon
                                                        3.Quit
                                                        """);
            if (option.equals("1")){
                String recipient = JOptionPane.showInputDialog("Enter recipient number(e.g.+27123456789)");
                String content = JOptionPane.showInputDialog("Enter message(max 250 characters)");
                
                Message m = new Message(recipient, content);
                
                if (!m.isValidMessageRecipient()){
                    JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain international code.");
                    i--;continue;
                }
                
                if (!m.isValidMessageLength()){
                    int over = content.length()-250;
                    JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by" + over + ".Please reduce.");
                    i--;continue;
                }
                
                String action = JOptionPane.showInputDialog("Choose one: Send/Store/Disregard");
                
                switch(action.toLowerCase()){
                    case "send": {
                        JOptionPane.showMessageDialog(null, "Message successfully sent");
                        sentMessages.add(m);
                        totalSent++;
                    }
                    case "store": {
                        storeToJson(m);
                        JOptionPane.showMessageDialog(null, "Message stored.");
                    }
                    case "disregard": {
                        JOptionPane.showMessageDialog(null, "Message disregarded. Press 0 to delete");
                    }
                    default:{
                        JOptionPane.showMessageDialog(null, "Invalid option.");
                        
                        i--;continue;
                    }
                }
                
              
            }else if (option.equals("2")){
                JOptionPane.showMessageDialog(null, "Coming Soon.");
                i--; //Does not count toward message total
            }else if (option.equals("3")){
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Invalid menu option.");
                i--;continue;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total messages sent:" + totalSent);
    }
    @SuppressWarnings("unchecked")
    private void storeToJson(Message m){
        JSONObject json = new JSONObject();
        json.put("messageId", m.getMessageId());
        json.put("recipient", m.getRecipient());
        json.put("message", m.getContent());
        json.put("hash", m.getMessageHash());
       
      try (FileWriter fw = new FileWriter("store_messages.json",true)){
          fw.write(json.toJSONString() + "\n");
      }catch(Exception e){
          e.printStackTrace();
      }
    }
    
    private void showMessageSummary(Message m){
        JOptionPane.showMessageDialog(null, """
                                            Message Details:
                                            ID:%s
                                            Hash:%s
                                            Recipient:%s
                                            Message:%s
                                            """.formatted(m.getMessageId(), m.createMessageHash(), m.getRecipient(), m.getContent()));
    }
    
    
    
    
    
     
        
                
    }
    

