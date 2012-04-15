package com.mnnit.server.net;

/**
 *
 * @author Lakhan
 */
public class NetworkService {

    private MessageReceiver messageReceiver;
    
    private MessageSender messageSender;
    
    private UDPSender udpSender;
    
    private UDPReceiver udpReceiver;
    
    public NetworkService (){
        messageReceiver = new MessageReceiver();
        messageSender = new MessageSender();
        udpSender = new UDPSender();
        udpReceiver = new UDPReceiver();
    }
    
    public void startNetworkService(){
        messageReceiver.startReceiver();
        messageSender.startSender();
        udpReceiver.startUDPReceiver();
        udpSender.startSender();
    }
    
    public boolean sendMulticastMessage(String msg)
    {
        return messageSender.send(msg);
    }
    
    public boolean sendUDPMsg(String msg, String ip, int port )
    {
        return udpSender.send(msg, ip, port);
    }
}
