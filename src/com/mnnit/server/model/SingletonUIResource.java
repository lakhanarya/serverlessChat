/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.model;

import com.mnnit.server.controller.ChatTextFieldController;
import com.mnnit.server.controller.MainChatController;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author darth
 */
public class SingletonUIResource {

    public static ChatTextFieldController getChatTextFieldController() {
        return chatTextFieldController;
    }

    public void setChatTextFieldController(ChatTextFieldController chatTextFieldController) {
        this.chatTextFieldController = chatTextFieldController;
    }

    public static MainChatController getMainChatController() {
        return mainChatController;
    }

    public void setMainChatController(MainChatController mainChatController) {
        this.mainChatController = mainChatController;
    }

        
    public static JTextField getWritingArea() {
        return mainChatField ;
    }

    public static JTextArea getMainChatArea() {
        return mainChatArea ;
    }
    
    public static JList getUserList()
    {
        return userList ;
    }
    
    
    public SingletonUIResource(JTextArea mainChatArea , JTextField mainChatField , JList userList)
    {
        this.mainChatArea = mainChatArea ;
        this.mainChatField = mainChatField ;
        this.userList = userList ;
        
        mainChatController = new MainChatController();
        chatTextFieldController = new ChatTextFieldController();
    }
    
    private static JTextArea mainChatArea ;
    private static JTextField mainChatField ;
    private static JList userList ;
    
    private static MainChatController mainChatController ;
    private static ChatTextFieldController chatTextFieldController ;
}
