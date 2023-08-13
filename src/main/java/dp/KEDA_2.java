package dp;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/13 14:48
 */
public class KEDA_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        char[] sCharArray = s.toCharArray();
        for(int i = 1;i < sCharArray.length;i++){
            k -= (sCharArray[i] - sCharArray[i - 1]);
            if(k < 0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(k);
    }
}
