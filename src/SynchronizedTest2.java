/**
 * static方法的锁
 * */

public class SynchronizedTest2 {
    public static void main(String[] args) {
        final InsertData2 insertData = new InsertData2();
        new Thread() {
            @Override
            public void run() {
                insertData.insert();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                insertData.insert1();
            }
        }.start();
    }
}
/**
 * 另外，每个类也会有一个锁，它可以用来控制对static数据成员的并发访问。
 　并且如果一个线程执行一个对象的非static synchronized方法，另外一个线程需要执行这个对象所属类的static synchronized方法，此时不会发生互斥现象，
 因为访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象。
 * */
class InsertData2 {
    public synchronized void insert(){
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public synchronized static void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行insert1完毕");
    }
}

