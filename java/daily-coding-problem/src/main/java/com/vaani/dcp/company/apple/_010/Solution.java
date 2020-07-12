package com.vaani.dcp.company.apple._010;

import java.util.concurrent.TimeUnit;

/**
 *
 * */
public class Solution {

    public static void main(String... args) {
        long fromTIme = System.currentTimeMillis();
        new JobScheduler().task(() -> System.out.println(System.currentTimeMillis() - fromTIme), TimeUnit.SECONDS.toMillis(5));
        System.out.println("-- done --");
    }

    public static final class JobScheduler {

        public void task(Runnable func, long delay) {
            new Thread(() -> {
                try {
                    Thread.sleep(delay);
                    func.run();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
