/* This class will act as a controller for the Text Field of main chat panel . This text  field will act 
 * both as a shell (for some specific commands like changing the nick name ) and also , for the handlers for
 * the textField 
 */
package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import javax.swing.JTextField;

/**
 *
 * @author darth
 */
public class ChatTextFieldController {
    
    public ChatTextFieldController(SingletonUIResource resource)
    {
        this.resource = resource;
        this.writingArea = resource.getWritingArea() ;
    }
    public void parseAndActOnMessage()
    {
        String message = writingArea.getText() ;
                writingArea.setText("");
            resource.getNetworkController().sendChatMessage(message); 
        if(message.startsWith("/"))
        {
            /*A shell command*/
            parseAndExecuteCommand(message);        
        }
    }
    
    private JTextField writingArea ; /* The writing area for the Main Chat*/
    private SingletonUIResource resource;
    private void parseAndExecuteCommand(String message) {

        String msg = message.substring(1);
        if(msg.startsWith("nick"))
        {
            if(msg.length()<=6)
                System.out.println("Specify Nick");
            else
            {
            String nick = msg.substring(5);
            
            resource.getNetworkController().sendNickChangeMessage(nick);
        
            }
        }
    }

    private void SendToMainChat(String message) {
        /*We need a global instance of the mainChat . For it , we also need to create a singleton*/
        MainChatController mainChatController = resource.getMainChatController();
        mainChatController.writeToMainChat(message);
        
    }
}
