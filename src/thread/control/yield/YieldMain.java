package thread.control.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000; // 1000개의 스레드가 1~9까지 출력 하도록.

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            MyRunnable myRunnable = new MyRunnable();
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);

                // 1. empty
                // 2. sleep(1)
//                sleep(1);
                // 3. Thread.yield()
                Thread.yield();
            }
        }
    }
}
