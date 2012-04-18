/*
 * Used for sending any type of message that the application supports
 */
package com.mnnit.server.net;

import com.mnnit.server.model.Settings;
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
        this.me = Settings.getSettings().getMe();
    }
    
    public void sendLogonMsg()
    {
        String msg = createMessage("LOGON");
        networkService.sendMulticastMessage(msg);
    }
    
    public void sendChatMessage(String msg)
    {
        String message = createMessage("CHAT");
        message += "@" + msg;
        networkService.sendMulticastMessage(message);
    }
    
    public String createMessage(final String type)
    {
        return me.getCode() + "#" + type + "!" + me.getNick();
    }
}
