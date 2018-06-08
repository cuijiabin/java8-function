package com.thread.series26;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrierTest2 {
    private static int SIZE = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE, new Runnable() {
            @Override
            public void run() {
                System.out.println("CyclicBarrier's parties is: " + cb.getParties());
            }
        });

        // 新建5个任务
        for (int i = 0; i < SIZE; i++) {
            new InnerThread().start();
        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();

                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
