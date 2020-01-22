package com.yeternal.retry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author: eternallove
 * @date: Created in 2019/7/11 16:02
 */
@Service
@Slf4j
public class TestService {

    private Random random = new Random();

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public int test() {
        int i = random.nextInt();
        log.info("Test:" + i);
        if (i > 100 || i < 0) {
            i = 0;
        }
        return 1 / i;
    }

    public int test2() {
        test();
        return test();
    }
}
