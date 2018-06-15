/**
 * 　读写锁将对一个资源（比如文件）的访问分成了2个锁，一个读锁和一个写锁。

 　　正因为有了读写锁，才使得多个线程之间的读操作不会发生冲突。

 　　ReadWriteLock就是读写锁，它是一个接口，ReentrantReadWriteLock实现了这个接口。

 　　可以通过readLock()获取读锁，通过writeLock()获取写锁。
 */


import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest3 {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final LockTest3 test = new LockTest3();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
