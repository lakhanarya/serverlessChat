package com.mnnit.server.net;

/**
 *
 * @author Lakhan
 */
public class NetworkService {

    private MessageReceiver messageReceiver;
    
    private MessageSender messageSender;
    
    public NetworkService (){
        messageReceiver = new MessageReceiver();
        messageSender = new MessageSender();
    }
    
    public void startNetworkService(){
        messageReceiver.startReceiver();
        messageSender.startSender();
    }
    
    public boolean sendMulticastMessage(String msg)
    {
        return messageSender.send(msg);
    }
    
}
