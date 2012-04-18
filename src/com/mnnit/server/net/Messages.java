/*
 * Used for sending any type of message that the application supports
 */
package com.mnnit.server.net;

import com.mnnit.server.model.EnvironmentalSettings;
import com.mnnit.server.model.User;

/**
 *
 * @author Lakhan
 */

public class Messages {

    private NetworkService networkService;
    private User me;
    
    public Messages(final NetworkService networkService)
    {
        this.networkService = networkService;
        this.me = EnvironmentalSettings.getMe();
    }
    
    public void sendLogonMsg()
    {
        String msg = createMessage("LOGON");
        networkService.sendMulticastMessage(msg);
    }
    
    
    public String createMessage(final String type)
    {
        return me.getCode() + "#" + type + "!" + me.getNick();
    }
}
