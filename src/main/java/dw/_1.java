package dw;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/29 11:31
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        String s = sc.next();
        char[] sCharArray = s.toCharArray();
        for(int i = 0;i < n - x - 1;i++){
            if(isHuiwen(sCharArray,i,i + x - 1)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean isHuiwen(char[] sCharArray, int start, int end) {
        while(start <= end){
            if(sCharArray[start] != sCharArray[end]){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
