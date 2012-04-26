/*
 * The main chat controller , the main purpose of this class is to tranfer and append messages to the 
 * main chat panel . 
 * TODO : We can implement smileys/commands etc. from this . But , in this version 1.0 , we will only
 * incorporate the core functionality 
 */
package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import javax.swing.JTextArea;

/**
 *
 * @author darth
 */
public class MainChatController {
    public MainChatController(SingletonUIResource resource)
    {
        this.mainChatArea = resource.getMainChatArea();
    }
    public void writeToMainChat(String mainChatMessage)
    {
        if(mainChatMessage==null)
        {
            throw new NullPointerException("main chat message is NULL");
        }
        else
        {
            /*By default , the messages are appended to the main Chat Frame*/
            mainChatArea.append(mainChatMessage +"\n");
        }
    }
    
    public void writeToMainChat(String mainChatMessage, String nick)
    {
        if(mainChatMessage==null)
        {
            throw new NullPointerException("main chat message is NULL");
        }
        else
        {
            /*By default , the messages are appended to the main Chat Frame*/
            mainChatArea.append(nick + "> " + mainChatMessage +"\n");
        }
    }
    
    public void clearMainChat()
    {
        mainChatArea.setText("");
    }
    
    public void clearAndWriteToMainChat(String mainChatMessage)
    {
        if(mainChatMessage==null)
        {
            throw new NullPointerException("main chat message is NULL");
        }
        clearMainChat();
        writeToMainChat(mainChatMessage);
    }
    private JTextArea mainChatArea ;/*The mainchat frame to be controlled*/
}
