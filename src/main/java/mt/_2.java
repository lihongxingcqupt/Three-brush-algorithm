package mt;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/12 10:08
 */
public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dis = new long[n];
        for(int i = 0;i < n;i++){
            dis[i] = sc.nextLong();
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        long sum1 = 0;
        long sum2 = 0;
        if(start > end){
            for(int i = end - 1;i < start - 1;i++){
                sum1 += dis[i];
            }
            for(int i = start - 1;i < dis.length;i++){
                sum2 += dis[i];
            }
            for(int i = 0;i < end - 1;i++){
                sum2 += dis[i];
            }
        }else{
            for(int i = start - 1;i < end - 1;i++){
                sum1 += dis[i];
            }
            for(int i = end - 1;i < dis.length;i++){
                sum2 += dis[i];
            }
            for(int i = 0;i < start - 1;i++){
                sum2 += dis[i];
            }
        }
        System.out.println(Math.min(sum1,sum2));
    }
}
