package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.model.User;
import com.mnnit.server.net.NetworkService;
import com.mnnit.server.event.ReceiverListener;
import com.mnnit.server.model.Settings;
import com.mnnit.server.net.Messages;

/**
 *
 * @author Lakhan
 */
public class NetworkController {

    private SingletonUIResource resource;
    private NetworkService networkService;
    private ReceiverListener receiverListener;
    private Messages messages;
    
    public NetworkController(SingletonUIResource resource)
    {
        this.resource = resource;
        this.networkService = new NetworkService();
        this.receiverListener = new ReceiverListener(resource);
        this.messages = new Messages(networkService);
        networkService.setReceiverListener(receiverListener);
    }
      
    public void logOn()
    {
        networkService.startNetworkService();
        User user = Settings.getSettings().getMe();
        resource.getUserListController().add(user);
        messages.sendLogonMsg();
        messages.sendExposeMsg();
    }
    
    public void sendChatMessage(String msg)
    {
        messages.sendChatMessage(msg);
    }
    
    public void sendNickChangeMessage(String nick)
    {
        messages.sendChangeNickMsg(nick);
    }

    public void sendNickCrashMessage(String nick) {
        messages.sendNickCrashMsg(nick);
    }

    public void sendExposingMessage() {
       messages.sendExposingMsg(); 
    }

    public void sendLogoffMessage() {
        messages.sendLogoff();
    }

    public void sendIdleMessage() {
        messages.sendIdleMessage();
    }

    public void sendBackMessage() {
        messages.sendBackMessage();
    }
    
    public void sendPrivateChatMessage(String msg, String ip)
    {
        messages.sendPrivateMsg(msg, ip);
    }
}
