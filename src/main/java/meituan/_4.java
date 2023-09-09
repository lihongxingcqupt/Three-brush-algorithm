package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/9 10:36
 */
public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = new int[n];
        res[0] = 1;
        int gap = 1;
        for(int i = 1;i < n;i++){
            if(res[i - 1] + gap <= m){
                res[i] = res[i - 1] + gap;
            }else{
                res[i] = m;
            }
            gap++;
        }
        for(int i = 0;i < n - 1;i++){
            System.out.print(res[i] + " ");
        }
        System.out.println(res[n - 1]);
    }
}
