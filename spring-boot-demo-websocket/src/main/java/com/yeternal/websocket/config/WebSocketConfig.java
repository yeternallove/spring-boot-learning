package com.yeternal.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.websocket.config
 * @description:
 * @author: eternallove
 * @date: Created in 2018/12/11 16:05
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
