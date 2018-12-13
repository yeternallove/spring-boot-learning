package com.yeternal.websocket.util;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.websocket.util
 * @description:
 * @author: eternallove
 * @date: Created in 2018/12/12 13:15
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
public class WebSocketManager {
    private static WebSocketManager webSocketManager;
    /**
     * 默认在线人数
     */
    public final static int INITIAL_CAPACITY = 50;

    private Map<String, Session> userMap;
    private AtomicLong onlineNumber;

    private WebSocketManager() {
        userMap = new ConcurrentHashMap<>(INITIAL_CAPACITY);
        onlineNumber = new AtomicLong();
    }

    public static WebSocketManager getInstance() {
        if (webSocketManager == null) {
            synchronized (WebSocketManager.class) {
                if (webSocketManager == null) {
                    webSocketManager = new WebSocketManager();
                }
            }
        }
        return webSocketManager;
    }

    public void login(Session session) {
        final String name = session.getId();
        if (userMap.containsKey(name)) {
            return;
        }
        userMap.put(name, session);
        final long count = onlineNumber.incrementAndGet();
        System.out.println("有新连接加入！当前在线人数为" + count);
    }

    public void logout(Session session) {
        final String name = session.getId();
        if (userMap.containsKey(name)) {
            userMap.remove(name);
            final long count = onlineNumber.decrementAndGet();
            System.out.println("有一连接关闭！当前在线人数为" + count);
        }
    }

    public Session get(String userName) {
        return userMap.get(userName);
    }
}
