package com.mnnit.server.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakhan
 */
public class MessageSender {
    
    /** Address for multicasting */
    private InetAddress address;
    
    /** Port for connection */
    private int port;
    
    /** Already Connected or not */
    private boolean connected = false;
    
    /** Multicast Socket */

    
    public MessageSender()
    {
        
    }
    
    public MessageSender(final String ipAddress, final int port)
    {
        this.port = port;
        try {
            address = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
 
}
