public class MythreadTest {
    public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();
        MyRunnable runnable=new MyRunnable();
        Thread thread3=new Thread(runnable);

        thread3.start();
        new Thread(){
            public void run(){
                System.out.println("这是匿名内部类吧");
            }
        }.start();;
    }
}



class MyRunnable implements Runnable{

    public MyRunnable() {

    }

    @Override
    public void run() {
        System.out.println("runable实现的子线程ID："+Thread.currentThread().getId());
    }
}

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
