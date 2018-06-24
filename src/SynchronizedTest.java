import java.util.ArrayList;
/**
 synchronized 关键字
 * */
public class SynchronizedTest {
    public static void main(String[] args)  {
        final InsertData insertData = new InsertData();

        new Thread(){
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();

    }
}
/**
 * 锁住方法
 * */
//class InsertData {
//    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//    public synchronized void insert(Thread thread){
//        for(int i=0;i<5;i++){
//            System.out.println(thread.getName()+"在插入数据"+i);
//            arrayList.add(i);
//        }
//    }
// }

/**
  synchronized(synObject) {

 }
  当在某个线程中执行这段代码块，该线程会获取对象synObject的锁，从而使得其他线程无法同时访问该代码块。

  synObject可以是this，代表获取当前对象的锁，也可以是类中的一个属性，代表获取该属性的锁。
 */

//class InsertData {
//    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//    public void insert(Thread thread){
//        synchronized (this) {
//            for(int i=0;i<100;i++){
//                System.out.println(thread.getName()+"在插入数据"+i);
//                arrayList.add(i);
//            }
//        }
//    }
//}
class InsertData {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Object object = new Object();

    public void insert(Thread thread){
        synchronized (object) {
            for(int i=0;i<100;i++){
                System.out.println(thread.getName()+"在插入数据"+i);
                arrayList.add(i);
            }
        }
    }





}

