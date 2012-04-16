/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.net;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakhan
 */
public class UDPSender {
    
    private DatagramSocket udpSocket;
    private boolean connected;
    
    public UDPSender()
    {
        
    }
    
    public boolean send(String msg, String ip, int port)
    {
        if(connected)
        {
            try {
                InetAddress address = InetAddress.getByName(ip);
                byte[] encodedMsg = msg.getBytes();
                int size = encodedMsg.length;
                DatagramPacket packet = new DatagramPacket(encodedMsg, size, address, port);
                udpSocket.send(packet);
                
                return true;
            } catch (IOException ex) {
                Logger.getLogger(UDPSender.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return false;
    }
    
    public void startSender()
    {
        if(connected)
            System.out.println("UDP Sender already connected");
        try {
            udpSocket = new DatagramSocket();
            connected = true;
        } catch (SocketException ex) {
            Logger.getLogger(UDPSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopSender()
    {
        if(!connected)
            System.out.println("Already stopped UDP Sender");
        else
        {
            connected = false;
            if(udpSocket!=null && !udpSocket.isClosed())
            udpSocket.close();
        }
    }
}
