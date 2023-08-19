package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/19 10:39
 */
public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String bing = sc.next();
        char[] bingCharArray = bing.toCharArray();
        int yaoNum = sc.nextInt();
        List<String[]> yao = new ArrayList<>();
        for(int i = 0;i < yaoNum;i++){
            String[] yaos = new String[2];
            yaos[0] = sc.next();
            yaos[1] = sc.next();
            yao.add(yaos);
        }
        int chiyaoNum = sc.nextInt();
        List<Integer> chiyao = new ArrayList<>();
        for(int i = 0;i < chiyaoNum;i++){
            chiyao.add(sc.nextInt());
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < chiyao.size();i++){
            int yaonum = chiyao.get(i);
            String[] yaoTemp = yao.get(yaonum - 1);
            int resTemp = 0;
            for(int j = 0;j < n;j++){
                if(yaoTemp[0].charAt(j) == '1'){
                    bingCharArray[j] = '0';
                }
                if(yaoTemp[1].charAt(j) == '1'){
                    bingCharArray[j] = '1';
                }
                if(bingCharArray[j] == '1'){
                    resTemp ++;
                }
            }
            res.add(resTemp);
        }
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
