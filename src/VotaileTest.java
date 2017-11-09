public class VotaileTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VotaileTest test = new VotaileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10;j++)
                        test.increase();
                    System.out.println(test.inc);
                };
            }.start();
        }

//        while(Thread.activeCount()>1)  //保证前面的线程都执行完
 //           Thread.yield();
        System.out.println(test.inc);
    }
}
