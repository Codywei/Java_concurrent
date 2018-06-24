/**
 关于线程中断的五个练习
 * */
import java.io.IOException;

public class ThreadTest {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws IOException {
//           第四个练习
//          ThreadTest test=new ThreadTest();
//          MyThread3 thread=test.new MyThread3();
//          thread.start();
//          System.out.println(thread.getId());
//          System.out.println(thread.getPriority());
//          thread.setStop(true);




//        //第三个练习
//        ThreadTest test = new ThreadTest();
//        MyThread2 thread = test.new MyThread2();
//        thread.start();
//        try {
//            Thread.currentThread().sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();





        //第二个练习
        System.out.println("进入线程"+Thread.currentThread().getName());
        ThreadTest test = new ThreadTest();
        MyThread1 thread1 = test.new MyThread1();
        thread1.start();
        System.out.println("进入线程"+Thread.currentThread().getName());

        try {
            System.out.println("线程"+Thread.currentThread().getName()+"等待");
            thread1.join();
            System.out.println("线程"+Thread.currentThread().getName()+"继续执行");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        //第一个练习
//        ThreadTest test = new ThreadTest();
//        MyThread thread1 = test.new MyThread();
//        MyThread thread2 = test.new MyThread();
//        thread1.start();
//        thread2.start();
    }

    class MyThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("进入线程"+Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println("线程"+Thread.currentThread().getName()+"执行完毕");
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }

    class MyThread2 extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("进入睡眠状态");
                Thread.currentThread().sleep(100000000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("得到中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }


    class MyThread3 extends Thread{
        private volatile boolean isStop = false;
        @Override
        public void run() {
            int i = 0;
            while(!isStop){
                i++;
                System.out.println(i);
            }
        }

        public void setStop(boolean stop){
            this.isStop = stop;
        }
    }


}
