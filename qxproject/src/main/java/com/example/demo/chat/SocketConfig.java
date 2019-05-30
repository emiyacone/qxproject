package com.example.demo.chat;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: qxproject
 * @description:
 * @author: 唐庆阳
 * @create: 2019-05-29 18:56
 **/
public class SocketConfig {

    private static SocketConfig instance;
    private Set<ChatRoom> sockets = new HashSet<>();

    public static SocketConfig getInstance(){
        if (null == instance)
            instance = new SocketConfig();
        return instance;
    }

    private SocketConfig(){
    }

    public Set<ChatRoom> getSockets() {
        return sockets;
    }

    public void add(ChatRoom socket){
        sockets.add(socket);
    }

    public void remove(ChatRoom socket){
        sockets.remove(socket);
    }
}
