package com.song.controller;

import org.junit.Test;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
//@EnableScheduling
public class testC {
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("1223423");
//            }
//        },1000,1000);
//        zyScheduled();
//    }

//    @Test
    @Scheduled(cron = "*/2 * * * * ?")
    public void zyScheduled() {
        System.out.println("zyScheduled....");
    }
}
