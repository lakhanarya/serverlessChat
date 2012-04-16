/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnnit.server.net;

/**
 *
 * @author Lakhan
 */
public interface ReceiverListener {
    
    public void messageReceived(String message, String ipAddress);
    
}
