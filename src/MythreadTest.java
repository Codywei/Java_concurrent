/**
 * 创建线程的几种方式
 *
 *
 * */



public class MythreadTest {
    public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();
        MyRunnable runnable=new MyRunnable();//实例化接口的实现类
        Thread thread3=new Thread(runnable);//将实例作为参数存入构造器中，这种方法无需继承Thread类，方便扩展


        thread3.start();
        new Thread(){//3.匿名内部类

            public void run(){
                System.out.println("这是匿名内部类吧");
            }
        }.start();;
    }
}



class MyRunnable implements Runnable{//1.实现runnable接口

    public MyRunnable() {

    }

    @Override
    public void run() {
        System.out.println("runable实现的子线程ID："+Thread.currentThread().getId());
    }
}

class MyThread extends Thread{// 2.继承Thread类
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:"+name+" 线程ID:"+Thread.currentThread().getId());
    }
}
