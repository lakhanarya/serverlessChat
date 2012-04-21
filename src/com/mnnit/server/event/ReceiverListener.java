package com.mnnit.server.event;

import com.mnnit.server.controller.MainChatController;
import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.net.MessageParser;

/**
 *
 * @author Lakhan
 */
public class ReceiverListener {
    
    private MainChatController chatController;
    private MessageParser parser;
    
    public ReceiverListener (SingletonUIResource resource)
    {
        this.chatController = resource.getMainChatController();
        parser = new MessageParser(resource);
        
    }
    
    public void messageReceived(String message, String ipAddress)
    {
        parser.parseMsg(message);
    }
}