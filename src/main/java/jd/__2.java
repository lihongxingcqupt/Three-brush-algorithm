package jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/2 10:30
 */
public class __2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0;i < n;i++){
            prices[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < m;i++){
            int money = sc.nextInt();
            int discount = sc.nextInt();
            if(map.containsKey(money)){
                map.put(money,Math.max(discount,map.get(money)));
            }else{
                map.put(money,discount);
            }
        }
        int cost = 0;
        for(int i = 0;i < prices.length;i++){
            int money = prices[i];
            for(int j = money;j > 0;j--){
                if(map.containsKey(j)){
                    money -= map.get(j);
                    break;
                }
            }
            cost += money;
        }
        System.out.println(cost);
    }
}
