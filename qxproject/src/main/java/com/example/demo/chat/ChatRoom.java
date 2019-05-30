package com.example.demo.chat;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

/**
 * @program: qxproject
 * @description: 聊天室
 * @author: 唐庆阳
 * @create: 2019-05-29 18:52
 **/
@Component
@ServerEndpoint("/chatroom")
public class ChatRoom {

    private Session session;
    private List<String> names = new ArrayList<>();
    private String username;

    @OnOpen
    public void open(Session session) {
        this.username = "用户-->" + session.getId();
        this.session = session;
        SocketConfig.getInstance().add(this);
        names.add(username);
        broadCast(username + " 进入聊天室！！");
    }

    @OnMessage
    public void receive(Session session, String msg) {
        broadCast(username + "：" + new Date().toString() + "<br> :"+msg);
    }

    @OnClose
    public void close(Session session) {
        SocketConfig.getInstance().remove(this);
        names.remove(username);
        broadCast(username + " 退出聊天室！！");
    }

    public void broadCast(String msg) {
        Set<ChatRoom> sockets = SocketConfig.getInstance().getSockets();
        System.out.println("sockets-->" + sockets.size());
        for (Iterator iterator = sockets.iterator(); iterator.hasNext(); ) {
            try {
                ChatRoom chatRoom = (ChatRoom) iterator.next();
                chatRoom.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
