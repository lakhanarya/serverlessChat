package com.mnnit.server.model;

import com.mnnit.server.Defaults;
import com.mnnit.server.ui.PrivateChatFrame;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lakhan
 */
public class User {
    
    /** Nick of user */
    private String nick;
    
    /** IP Address */
    private String ipAddress;
    
    private String operatingSystem;
    private final int code;
    private int privateChatPort;
    private boolean me;
    private boolean online;
    private boolean idle;
    private boolean writing;
    private PrivateChatFrame frame;
    /** Blocked List */
    List<User> blocked;
    
    // One member for private chat window
    
    public User(String nick, int code)
    {
        this.nick = nick;
        this.code = code;
        
        this.ipAddress = "unknown";
        this.operatingSystem = "unkonwn";
        this.me = false;
        this.privateChatPort = Defaults.private_chat_port;
        this.online = true;
        this.idle = false;
        this.writing = false;
        this.blocked = new LinkedList<User>();
    }
    
    public void reset()
    {
        ipAddress = "unknown";
        me = false;
        privateChatPort = 0;
        idle = false;
        writing = false;
    }
    
    public String toString()
    {
        return nick;
    }
    
    public boolean isBlocked(User user)
    {
        return blocked.contains(user);
    }
    
    public void addBlocked(User user)
    {
        blocked.add(user);
    }
    
    public void setWriting(boolean writing)
    {
        this.writing = writing;
    }
    
    public boolean isWriting()
    {
        return writing;
    }
    public boolean isIdle()
    {
        return idle;
    }
    
    public void setIdle(boolean idle)
    {
        this.idle = idle;
    }
    public boolean isMe()
    {
        return me;
    }
    
    public void setMe(boolean me)
    {
        this.me = me;
    }
    
    public int getCode()
    {
        return code;
    }
    
    public String getNick()
    {
        return nick;
    }
    
    public void setNick(String nick)
    {
        this.nick = nick;
    }
    
    public String getOperatingSystem()
    {
        return operatingSystem;
    }
    
    public void setOperatingSystem(String operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }
    
    public boolean isOnline()
    {
        return online;
    }
    
    public void setOnline(boolean online)
    {
        this.online = online;
    }
    
    public String getIpAddress()
    {
        return ipAddress;
    }
    
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
    
    public int getPrivateChatPort()
    {
        return privateChatPort;
    }
    
    public void setPrivateChatPort(int port)
    {
        privateChatPort = port;
    }
    
    public void setPrivateChatFrame(PrivateChatFrame frame)
    {
        this.frame = frame;
    }

    public PrivateChatFrame getPrivateChatFrame() {
        return frame;
    }
}
