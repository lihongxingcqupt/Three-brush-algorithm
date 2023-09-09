package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/9 10:02
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        String temp = new String(s);
        while (k > 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < temp.length();i++){
                if(temp.charAt(i) == 'a'){
                    sb.append("bc");
                }else if(temp.charAt(i) == 'b'){
                    sb.append("ca");
                }else{
                    sb.append("ab");
                }
            }
            temp = new String(sb);
            k--;
        }
        System.out.println(temp);
    }
}
