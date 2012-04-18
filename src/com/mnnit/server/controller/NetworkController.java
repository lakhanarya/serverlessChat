package com.mnnit.server.controller;

import com.mnnit.server.model.SingletonUIResource;
import com.mnnit.server.model.User;
import com.mnnit.server.net.NetworkService;
import com.mnnit.server.event.ReceiverListener;

/**
 *
 * @author Lakhan
 */
public class NetworkController {

    private SingletonUIResource resource;
    private NetworkService networkService;
    private ReceiverListener receiverListener;
    
    public NetworkController(SingletonUIResource resource)
    {
        this.resource = resource;
        this.networkService = new NetworkService();
        this.receiverListener = new ReceiverListener(resource);
        networkService.setReceiverListener(receiverListener);
    }
    
    public void sendLogonMsg()
    {
        networkService.sendMulticastMessage("LOGON" );
    }
    
    public void logOn()
    {
        networkService.startNetworkService();
        User user = new User("nick", 123);
        resource.getUserListController().add(user);
    }
    
    public void sendChatMessage(String msg)
    {
        networkService.sendMulticastMessage(msg);
    }
}
