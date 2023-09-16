package meituan;

/**
 * @Author lihongxing
 * @Date 2023/9/16 10:28
 */
public class _16 implements Runnable{
    private static int i = 0;
    private static synchronized void add(){
        i++;
    }
    @Override
    public void run() {
        for(int j = 0;j < 10000;j++){
            add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new _16());
        Thread t2 = new Thread(new _16());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
