/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.net;

import com.mnnit.server.controller.MainChatController;
import com.mnnit.server.model.SingletonUIResource;

/**
 *
 * @author Lakhan
 */
public class ReceiverListener {
    
    private MainChatController chatController;
    
    public ReceiverListener (SingletonUIResource resource)
    {
        this.chatController = resource.getMainChatController();
    }
    
    public void messageReceived(String message, String ipAddress)
    {
        chatController.writeToMainChat(message);
    }
/**
 *
 * @author Lakhan
 */
}