package com.yeternal.retry.controller;

import com.yeternal.retry.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author: eternallove
 * @date: Created in 2019/7/11 16:06
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public int test() {
        return testService.test();
    }

    @GetMapping("/test2")
    public int test2() {
        return testService.test2();
    }
}
