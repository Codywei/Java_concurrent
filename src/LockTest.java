/**
 * lock方法和trylock方法
 　　(1)Lock不是Java语言内置的，synchronized是Java语言的关键字，因此是内置特性。Lock是一个类，通过这个类可以实现同步访问；

 　　(2)Lock和synchronized有一点非常大的不同，采用synchronized不需要用户去手动释放锁，当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；

        而Lock则必须要用户去手动释放锁，如果没有主动释放锁，就有可能导致出现死锁现象。

 * */


import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    private Lock lock = new ReentrantLock();
    public static void main(String[] args)  {
        final LockTest test = new LockTest();
        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
//        lock.lock();
//        try {
//            System.out.println(thread.getName()+"得到了锁");
//            for(int i=0;i<5;i++) {
//                arrayList.add(i);
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        }finally {
//            System.out.println(thread.getName()+"释放了锁");
//            lock.unlock();
//        }


        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<1000000;i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }




    }

