package fp;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/10/7 19:38
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int index = 0;
        int num = 1;
        while (index < s.length()){
            String numStr = num + "";
            String nowStr = s.substring(index,index + numStr.length());
            int nowNum = Integer.parseInt(nowStr);
            if(nowNum != num){
                int len = 0;
                String numStrTemp = num + "";
                for(int i = 0;i < nowStr.length() && i < numStrTemp.length();i++){
                    if(nowStr.charAt(i) == numStrTemp.charAt(i)){
                        len ++;
                    }else{
                        break;
                    }
                }
                System.out.println(index + len);
                return;
            }
            num ++;
            index += numStr.length();
        }
    }
}
