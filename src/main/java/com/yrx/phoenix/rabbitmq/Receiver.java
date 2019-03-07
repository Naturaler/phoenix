// package com.yrx.phoenix.rabbitmq;
//
// import org.springframework.stereotype.Component;
//
// import java.util.concurrent.CountDownLatch;
//
// /**
//  * Created by r.x on 2019/3/6.
//  */
// @Component
// public class Receiver {
//
//     private CountDownLatch latch = new CountDownLatch(1);
//
//     public void receiveMessage(String message) {
//         System.out.println("Received <" + message + ">");
//         latch.countDown();
//     }
//
//     public CountDownLatch getLatch() {
//         return latch;
//     }
//
// }