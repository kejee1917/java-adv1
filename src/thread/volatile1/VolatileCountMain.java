package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();

        sleep(1000);

        log("false 로 변경");
        myTask.flag = false;
        log("flag = "  + myTask.flag + ", count = " + myTask.count + " in main");

        log("main 종료");
    }

    static class MyTask implements Runnable {

//        boolean flag = true;
//        long count;

        volatile boolean flag = true;
        volatile long count;

        @Override
        public void run() {
            while (flag) {
                count++;
                if (count % 100_000_000 == 0) {
                    log("flag = "  + flag + ", count = " + count + " in while");
                }
            }
            log("flag = "  + flag + ", count = " + count + " 종료");
        }
    }
}
