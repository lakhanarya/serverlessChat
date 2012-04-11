
package com.mnnit.server.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakhan
 */
public class MessageReceiver implements Runnable {
    
    
    /** Address for multicasting */
    private InetAddress address;
    
    /** Port for connection */
    private int port;
    
    /** Already Connected or not */
    private boolean connected = false;
    
    /** Multicast Socket */
    private MulticastSocket mcSocket;
    
    public static void main (String args[])
    {
        MessageReceiver mr = new MessageReceiver("224.168.5.200", 40556);
        mr.startReceiver();
        mr.run();
    }
    
    public MessageReceiver(final String ipAddress, final int port)
    {
        this.port = port;
        try {
            address = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MessageSender.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
    
    public synchronized boolean startReceiver ()
    {
        if(connected)
        {
            System.out.println("Already Connected");
        }
        else
        {
            try {
            if(mcSocket==null)
                mcSocket = new MulticastSocket(port);
            mcSocket.joinGroup(address);
            mcSocket.setTimeToLive(64);
            connected=true;
            }
            catch (final IOException e)
            {
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

    @Override
    public void run() {
        while ( connected )
		{
			try
			{
				DatagramPacket packet = new DatagramPacket(
						new byte[1024], 1024 );

				if ( connected )
				{
					mcSocket.receive( packet );
					String ip = packet.getAddress().getHostAddress();
					String message = new String( packet.getData() ).trim();
					System.out.println( "Message arrived from " + ip + ": " + message );
				}
			}

			// Happens when socket is closed, or network is down
			catch ( final IOException e )
			{
				e.printStackTrace();
			}
		}
    }
}
