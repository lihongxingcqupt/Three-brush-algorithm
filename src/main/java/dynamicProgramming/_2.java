package dynamicProgramming;

import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/8/19 16:55
 */
public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for(int i = 0;i < n;i++){
            s[i] = sc.next();
        }
        for(int i = 0;i < n;i++){
            if(getOut(s[i])){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean getOut(String s) {
        StringBuffer sb = new StringBuffer();
        // 统一处理
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            // w
            if(c == 'w'){
                sb.append("vv");
            }else if(c == 'm'){
                sb.append("nn");
                //统一处理成b
            }else if(c == 'd' || c == 'p' || c == 'q'){
                sb.append("b");
            }else if(c == 'u'){
                sb.append('n');
            }else{
                sb.append(c);
            }
        }
        return ishuiwen(sb);
    }

    private static boolean ishuiwen(StringBuffer sb) {
        // 判断是不是回文串
        int left = 0;
        int right = sb.length() - 1;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return  false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
