package com.mnnit.server.net;

import com.mnnit.server.model.User;
import com.mnnit.server.ui.PrivateChatFrame;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lakhan
 */
public class PrivateMessageResponder {
 
    private static Map<String, User> map = new HashMap<String, User>();
    
    public static void addChatWindow(User user)
    {
        map.put(user.getIpAddress(), user);
    }
    
    public static PrivateChatFrame getChatWindow(String ipAddress)
    {
        return map.get(ipAddress).getPrivateChatFrame();
    }
}
