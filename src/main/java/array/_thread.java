package array;

/**
 * @Author lihongxing
 * @Date 2023/12/11 10:29
 */
public class _thread {
    private static final Object lock = new Object();
    private static int currentThread = 1;
    private static int count = 1;
    private static final int MAX_COUNT = 100;
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> printNumbers(1));
        Thread thread2 = new Thread(() -> printNumbers(2));
        Thread thread3 = new Thread(() -> printNumbers(3));
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void printNumbers(int expectedThreadId) {
        synchronized (lock) {
            while (count <= MAX_COUNT) {
                // 判断是否轮到当前线程打印
                while (currentThread != expectedThreadId && count <= MAX_COUNT) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 打印当前数字并递增计数器
                if (count <= MAX_COUNT) {
                    System.out.println("Thread " + expectedThreadId + ": " + count);
                    count++;
                }

                // 更新当前轮到的线程
                currentThread = (currentThread % 3) + 1;

                // 唤醒其他等待的线程
                lock.notifyAll();
            }
        }
    }
}
