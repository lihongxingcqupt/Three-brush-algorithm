package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/9 10:23
 */
public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        getLastStr(s,k);
    }

    //获取结果
    private static void getLastStr(String s, int k) {
        if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            System.out.println(s.length());
            return;
        }
        int n = 0;
        StringBuilder sb = new StringBuilder(s);
        // 模拟
        while (k > 0 && n < s.length() - 1){
            if(sb.charAt(n) == sb.charAt(n + 1)){
                k --;
                sb.replace(n,n+1,String.valueOf('1' - sb.charAt(n)));
            }
            n += 2;
        }
        while (k > 0){
            sb.replace(s.length() - 1,s.length(),String.valueOf('1' - sb.charAt(s.length() - 1)));
            k--;
        }
        int m = 1;
        while(m < s.length()){
            if(sb.charAt(m) != sb.charAt(m - 1)){
                System.out.println(s.length() - m - 1);
                return;
            }
            m += 2;
        }
        if(sb.length() % 2 == 1){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
