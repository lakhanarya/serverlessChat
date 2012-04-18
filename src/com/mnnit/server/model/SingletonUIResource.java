/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.model;

import com.mnnit.server.controller.ChatTextFieldController;
import com.mnnit.server.controller.MainChatController;
import com.mnnit.server.controller.NetworkController;
import com.mnnit.server.controller.UserListController;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author darth
 */
public class SingletonUIResource {

    public ChatTextFieldController getChatTextFieldController() {
        return chatTextFieldController;
    }

    public void setChatTextFieldController(ChatTextFieldController chatTextFieldController) {
        this.chatTextFieldController = chatTextFieldController;
    }

    public MainChatController getMainChatController() {
        return mainChatController;
    }

    public void setMainChatController(MainChatController mainChatController) {
        this.mainChatController = mainChatController;
    }

    public NetworkController getNetworkController()
    {
        return networkController;
    }
    
    public void setNetworkController(NetworkController networkController)
    {
        this.networkController = networkController;
    }
    
    public JTextField getWritingArea() {
        return mainChatField ;
    }

    public JTextArea getMainChatArea() {
        return mainChatArea ;
    }
    
    public JList getUserList()
    {
        return userList ;
    }
    
    public UserListController getUserListController()
    {
        return userlistController;
    }
    
    public void setUserListController (UserListController controller)
    {
        this.userlistController = controller;
    }
    
    public SingletonUIResource(JTextArea mainChatArea , JTextField mainChatField , JList userList)
    {
        this.mainChatArea = mainChatArea ;
        this.mainChatField = mainChatField ;
        this.userList = userList ;
        
        mainChatController = new MainChatController(this);
        chatTextFieldController = new ChatTextFieldController(this);
        networkController = new NetworkController(this);
        userlistController = new UserListController(this);
    }
    
    private JTextArea mainChatArea ;
    private JTextField mainChatField ;
    private JList userList ;
    
    private MainChatController mainChatController ;
    private ChatTextFieldController chatTextFieldController ;
    private NetworkController networkController;
    private UserListController userlistController;
}
