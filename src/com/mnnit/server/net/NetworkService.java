package com.mnnit.server.net;

import com.mnnit.server.event.ReceiverListener;

/**
 *
 * @author Lakhan
 */
public class NetworkService {

    private MulticastReceiver messageReceiver;
    
    private MulticastSender messageSender;
    
    private UDPSender udpSender;
    
    private UDPReceiver udpReceiver;
    
    public NetworkService (){
        messageReceiver = new MulticastReceiver();
        messageSender = new MulticastSender();
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
    
    public void setReceiverListener(ReceiverListener listener)
    {
        messageReceiver.registerListener(listener);
    }
    public void setUDPListener(ReceiverListener listener)
    {
        udpReceiver.registerListener(listener);
    }
}