/* This class will act as a controller for the Text Field of main chat panel . This text  field will act 
 * both as a shell (for some specific commands like changing the nick name ) and also , for the handlers for
 * the textField 
 */
package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author darth
 */
public class ChatTextFieldController {
    
    public ChatTextFieldController()
    {
        this.writingArea = SingletonUIResource.getWritingArea() ;
    }
    public void parseAndActOnMessage()
    {
        String message = writingArea.getText() ;
        if(message.startsWith("/"))
        {
            /*A shell command*/
            parseAndExecuteCommand();
            return ;
        }
        else
        {
            /*A normal message*/
            SendToMainChat(message); 
        }
    }
    
    private JTextField writingArea ; /* The writing area for the Main Chat*/

    private void parseAndExecuteCommand() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void SendToMainChat(String message) {
        /*We need a global instance of the mainChat . For it , we also need to create a singleton*/
        MainChatController mainChatController = SingletonUIResource.getMainChatController();
        mainChatController.writeToMainChat(message);
        writingArea.setText("");
        return ;
    }
}