package tx;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/8 10:27
 */
public class _3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        char[] sCharArray = s.toCharArray();
        int index = 0;
        int cnt = 0;
        while(true){
            if(sCharArray[index % n] == 'A'){
                cnt ++;
            }
            if(cnt == k){
                System.out.println(index + 1);
                return;
            }
            index ++;
        }
    }
}
