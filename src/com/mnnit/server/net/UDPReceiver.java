
package com.mnnit.server.net;

import com.mnnit.server.event.ReceiverListener;
import com.mnnit.server.Defaults;
import com.mnnit.server.ui.PrivateChatFrame;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lakhan
 */
public class UDPReceiver implements Runnable{
    
    private boolean connected;
    private DatagramSocket udpSocket;
    private Thread th;
    private ReceiverListener listener;
    private PrivateChatFrame frame;
    

    public void startUDPReceiver()
    {
		if ( connected )
                    System.out.println("Already Connected UDP reciever");

		else
		{
			int port = Defaults.private_chat_port;
			int counter = 0;

			while ( counter < 10 && !connected )
			{
				try
				{
					udpSocket = new DatagramSocket( port );
					connected = true;
					th = new Thread( this, "UDPReceiver" );
					th.start();					
				}

				catch ( final IOException e )
				{
					counter++;
					port++;
				}
			}

			if ( !connected )
			{     
                            System.out.println("Unable to connect");
			}
		}
    }

    public void stopSender()
    {
        if(!connected)
        {
            System.out.println("Already stopped");
        }
        else
        {
            if(udpSocket!=null && !udpSocket.isClosed())
                udpSocket.close();
            connected = false;
        }
    }
    
    @Override
    public void run() {
        if(!connected)
        {
            try {
                DatagramPacket packet = new DatagramPacket(
                                                    new byte[Defaults.packet_size], Defaults.packet_size );
                udpSocket.receive( packet );
                String ip = packet.getAddress().getHostAddress();
                String message = new String( packet.getData() ).trim();
                if(listener!=null)
                listener.udpMessageReceived(message, ip);
            } catch (IOException ex) {
                Logger.getLogger(UDPReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
					
        }
    }
    
    public void registerListener(ReceiverListener listener)
    {
        this.listener = listener;
    }
}
