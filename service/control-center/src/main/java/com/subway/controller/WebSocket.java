package com.subway.controller;

import com.subway.exception.MyException;
import com.subway.result.ResultCode;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/center/webSocket")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("建立连接");
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        System.out.println("关闭连接");
    }

    @OnMessage
    public void onMessage(String message) {

    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            System.out.println("【websocket消息】广播消息, message={}"+ message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                throw new MyException(ResultCode.ERROR,"上传失败");
            }
        }
    }
}
