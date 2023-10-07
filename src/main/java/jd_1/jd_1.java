package jd_1;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/23 19:44
 */
public class jd_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] red = new int[n];
        for(int i = 0;i < n;i++){
            red[i] = sc.nextInt();
        }
        int[] blue = new int[n];
        for(int i = 0;i < n;i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            blue[i] = red[left] + red[right];
        }
        int res = 0;
        for(int i = 0;i < n;i++){
            res += Math.min(red[i],blue[i]);
        }
        System.out.println(res);
    }
}
