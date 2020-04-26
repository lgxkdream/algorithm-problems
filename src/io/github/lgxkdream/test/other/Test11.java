package io.github.lgxkdream.test.other;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test11
 * @description
 * @since 2020-02-20 20:15
 */
public class Test11 {

    public static void main(String[] args) {
        Runnable tr = new TestRunnable();
        Thread thread = new Thread(tr);
        // thread.setDaemon(true); //设置守护线程
        thread.start(); //开始执行分进程
        System.out.println("stop");
    }

}

class TestRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);//守护线程阻塞1秒后运行
                System.out.println("klsjalfjaslfjalsjfdlkad");
            } catch (Exception e) {

            }
        }
    }
}
