/**
 * ThreadLocal练习
 * ThreadLocal，很多地方叫做线程本地变量，也有些地方叫做线程本地存储。
 * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。
 *
 * 在数据库连接中，若connect为共享变量将影响线程安全，而同步处理会影响效率，所以常见方法是采用ThreadLocal
 * */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}