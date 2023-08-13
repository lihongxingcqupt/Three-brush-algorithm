package dp;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/13 15:31
 */
public class KEDA_3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0;i < n;i++){
            sb1.append(sc.nextInt());
        }
        for(int i = 0;i < n;i++){
            sb2.append(sc.nextInt());
        }
        System.out.println(count(sb1,sb2)+n);
    }
    static int count(StringBuilder sb1,StringBuilder sb2){
        HashSet<String> set = new HashSet<>();
        for(int i = 2;i <= sb1.length();i++){
            for(int j = 0;j + i <= sb1.length();j++){
                set.add(deal(sb1.substring(j,j+i)));
            }
        }
        for(int i = 2;i <= sb2.length();i++){
            for(int j = 0;j + i <= sb2.length();j++){
                set.add(deal(sb2.substring(j,j+i)));
            }
        }
        return set.size();
    }

    private static String deal(String substring) {
        StringBuilder s = new StringBuilder(substring);
        if(s.charAt(0) > s.charAt(s.length() - 1)){
            return s.reverse().toString();
        }else{
            return substring;
        }
    }
}
