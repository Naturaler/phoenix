package com.yrx.phoenix.thread;

import java.util.concurrent.*;

/**
 * Created by r.x on 2019/4/14.
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("start");
        Callable<String> callable = () -> {
            Thread.sleep(3000);
            return "abcd";
        };
        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println(task.get(2000, TimeUnit.MILLISECONDS));
        System.out.println("end");
    }
}
