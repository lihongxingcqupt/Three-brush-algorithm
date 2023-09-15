package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/10 20:35
 */
public class tx_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aaaay = new int[n];
        for(int i = 0;i < n;i++){
            aaaay[i] = sc.nextInt();
        }
        Arrays.sort(aaaay);
        if(n == 1){
            System.out.println(aaaay[0]);
            return;
        }
        if(n == 2){
            System.out.println(aaaay[1]);
            return;
        }
        int lllfet = 0;
        int rrnhgt = n - 2;
        int ress = aaaay[n - 1];
        while(lllfet < rrnhgt){
            ress += aaaay[rrnhgt] - aaaay[lllfet];
            rrnhgt --;
            lllfet ++;
        }
        System.out.println(ress);
    }
}
