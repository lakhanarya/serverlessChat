
package com.mnnit.server.net;

import com.mnnit.server.Defaults;
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
    
    /** Listener */
    private ReceiverListener listener;
    
    private Thread th;
    
    public MessageReceiver()
    {
        this(Defaults.ipAddress, Defaults.port);
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
        if ( connected && ( th == null || !th.isAlive() ) )
		{
			startThread();
		}
        return connected;
    }

    public void run() {
        while ( connected )
		{
			try
			{
				DatagramPacket packet = new DatagramPacket(
						new byte[Defaults.packet_size], Defaults.packet_size );

				if ( connected )
				{
					mcSocket.receive( packet );
					String ip = packet.getAddress().getHostAddress();
					String message = new String( packet.getData() ).trim();
					System.out.println( "Message arrived from " + ip + ": " + message );
                                        if(listener!=null)
                                        listener.messageReceived(message, ip);
				}
			}

			// Happens when socket is closed, or network is down
			catch ( final IOException e )
			{
				e.printStackTrace();
			}
		}
    }
    
    public void startThread() {
        th = new Thread(this, "MessageReceiverThread");
        th.start();
    }
    
    public void registerListener(ReceiverListener listener)
    {
        this.listener=listener;
    }
}
