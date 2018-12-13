package com.yeternal.websocket.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.yeternal.websocket.util.WebSocketManager;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.websocket.service
 * @description:
 * @author: eternallove
 * @date: Created in 2018/12/11 16:11
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocketServer {

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        WebSocketManager.getInstance().login(session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        WebSocketManager.getInstance().logout(session);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        println("来自客户端{{}}的消息{}", session.getId(), message);
        final Session mgr = WebSocketManager.getInstance().get("0");
        if (mgr == null) {
            return;
        }
        try {
            mgr.getBasicRemote().sendText(message);
        } catch (IOException e) {
            println("WebSocketServer.onMessage 出错啦{}", e);
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        println("发生错误");
        error.printStackTrace();
    }

    public static void println(String message, Object... pram) {
        String format = StrUtil.format("{}【专用输出】{}", DateUtil.now(), message);
        String msg = StrUtil.format(format, pram);
        System.out.println(msg);
    }
}
