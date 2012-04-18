package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.model.User;
import com.mnnit.server.net.NetworkService;
import com.mnnit.server.event.ReceiverListener;
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
        User user = resource.getUserListController().createNewUser();
        resource.getUserListController().add(user);
        messages.sendLogonMsg();
    }
    
    public void sendChatMessage(String msg)
    {
        
    }
}
