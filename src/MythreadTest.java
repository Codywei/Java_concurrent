/**
  创建线程的几种方式
 * */



public class MythreadTest {
    public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());

        MyThread thread1 = new MyThread("thread1");
        //start方法新建一个线程
        thread1.start();


        MyThread thread2 = new MyThread("thread2");
        //run方法在原线程执行
        thread2.run();


        //实例化接口的实现类
        MyRunnable runnable=new MyRunnable();
        //将实例作为参数存入构造器中，这种方法无需继承Thread类，方便扩展
        Thread thread3=new Thread(runnable);
        thread3.start();



        new Thread(){
            //3.匿名内部类
            @Override
            public void run(){
                System.out.println("这是匿名内部类吧");
            }
        }.start();;
    }
}


/**
 * 1.实现runnable接口
 */

class MyRunnable implements Runnable{

    public MyRunnable() {

    }

    @Override
    public void run() {
        System.out.println("runable实现的子线程ID："+Thread.currentThread().getId());
    }
}
/**
 * 2.继承Thread类
 */

class MyThread extends Thread{
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:"+name+" 线程ID:"+Thread.currentThread().getId());
    }
}
