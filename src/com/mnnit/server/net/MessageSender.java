package com.mnnit.server.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
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
    private MulticastSocket mcSocket;
    
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
   
    public synchronized void stopSender()
    {
        if(!connected)
        {
            System.out.println("Not Connected");
        }
        else
        {
            connected = false;
            try {
                if(!mcSocket.isClosed())
                       mcSocket.leaveGroup(address);
            }
                 catch (IOException ex) {
                    Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(!mcSocket.isClosed())
            {
                mcSocket.close();
                mcSocket=null;
            }
        }
    }
    
    public synchronized boolean startSender()
    {
        if(connected)
            System.out.println("Socket Already Connected");
        else
        {
            try
            {
            if(mcSocket==null)
                mcSocket = new MulticastSocket();
            mcSocket.joinGroup(address);
            mcSocket.setTimeToLive(64);
            connected=true;
            }
            catch (final IOException e)
            {
                e.printStackTrace();
                if ( mcSocket != null )
		{
			if ( !mcSocket.isClosed() )
				mcSocket.close();
			mcSocket = null;
		}
            }
        }
        return connected;
    }
}
