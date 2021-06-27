package com.subway.thread;

import com.subway.exception.MyException;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtil {
    private static ThreadPoolExecutor threadPoolExecutor;

    static {
        threadPoolExecutor = new ThreadPoolExecutor(9,
                80,
                15,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(81),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()//报异常
                );
    }

    public static void execute(Runnable runnable){
        try {
            threadPoolExecutor.execute(runnable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(201,"系统出现异常，请稍后重试",null);
        }
    }

    public static void main(String[] args) {
        for (int i = 1;i <= 100;i++){

        }
    }
}
