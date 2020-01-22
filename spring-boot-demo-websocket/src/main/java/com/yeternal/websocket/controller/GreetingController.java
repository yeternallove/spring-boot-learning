package com.yeternal.websocket.controller;

import com.yeternal.websocket.model.Greeting;
import com.yeternal.websocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.websocket.controller
 * @description:
 * @author: eternallove
 * @date: Created in 2018/12/13 15:48
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */
@Controller
public class GreetingController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    /**
     * this.simpMessagingTemplate.convertAndSend("/topic/greetings", value);
     *
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/hello")
    @SendToUser("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
