package twoNidle;

import org.junit.Test;

import java.util.Vector;

/**
 * @Author lihongxing
 * @Date 2023/10/9 14:41
 */
class Solution {
    public static void main( String[] args ) {
        Vector v = new Vector();
        while (true){
            byte b[] = new byte[10240*5];
            v.add(b);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int busyTime = 10;
                    int idleTime = busyTime;
                    long startTime = 0;
                    while (true){
                        startTime = System.currentTimeMillis();
                        System.out.println(System.currentTimeMillis()+","+startTime+","+(System.currentTimeMillis() - startTime));
                        while ((System.currentTimeMillis() - startTime) <= busyTime);
                        try {
                            Thread.sleep(idleTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();// TODO run没开启
        }
    }
}

