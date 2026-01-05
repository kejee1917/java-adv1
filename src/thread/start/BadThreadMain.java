package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출전");
        helloThread.run(); // run 직접 실행하면 main이 실행해버림
        System.out.println(Thread.currentThread().getName() + " : start() 호출후");

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
