package com.cbms.util;

import org.springframework.stereotype.Component;

@Component
public class ThreadLocalUtil {
    public static void main(String[] args) {
        InheritableThreadLocal threadLocal = new InheritableThreadLocal();
        threadLocal.set("111");

        System.out.println(""+Thread.currentThread()+threadLocal.get());

        new Thread(()->{
            System.out.println(""+Thread.currentThread()+threadLocal.get());
        }).start();
    }
}
