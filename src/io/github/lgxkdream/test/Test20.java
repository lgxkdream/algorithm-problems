package io.github.lgxkdream.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-29 20:32
 */
public class Test20 {

    private static ThreadLocal<SimpleDateFormat> sdfHolder = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new TestTask(sdfHolder)).start();
        }
    }


    public static void main1(String[] args) {
        // all these objects have a strong reference
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        // other references to these objects
        Object strongA = a;
        SoftReference<Object> softB = new SoftReference<>(b);
        WeakReference<Object> weakC = new WeakReference<>(c);

        // free the former strong references to these objects:

        // there is still a strong reference(strongA) to the first object
        a = null;
        // only a soft reference(softB) refers to the second object
        b = null;
        // only a weak reference(weakC) refers to the third object
        c = null;

        System.out.println("Before gc...");
        System.out.println(String.format("strongA = %s, softB = %s, weakC = %s", strongA, softB.get(), weakC.get()));

        System.out.println("Run GC...");

        System.gc();

        // object with only soft reference will be cleaned only if memory is not enough: 用来做缓存很不错
        // object with only weak reference will be cleaned after a gc operation:
        System.out.println("After gc...");
        System.out.println(String.format("strongA = %s, softB = %s, weakC = %s", strongA, softB.get(), weakC.get()));
    }

}

class TestTask implements Runnable {

    private ThreadLocal<SimpleDateFormat> sdfHolder;

    public TestTask(ThreadLocal<SimpleDateFormat> sdfHolder) {
        this.sdfHolder = sdfHolder;
    }

    private boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            String formatedDateStr = sdfHolder.get().format(new Date());
            System.out.println("formated date str:" + formatedDateStr);
            //may be sleep for a while to avoid high cpu cost
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sdfHolder.remove();
    }

    //something else
}