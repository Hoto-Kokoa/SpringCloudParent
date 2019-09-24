package com.example.demo.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTimer {
    @Scheduled(fixedRate = 10000)
    public void tsetTask() {
        System.out.println("定时器");
    }
}
