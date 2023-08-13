package dp;

import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/8/13 15:42
 */
public class KEDA_3_3 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        int n,d,sum = 1;
        int[] a = new int[100010];
        int num = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            d = sc.nextInt();
            map.put(d,i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
        }
        for(int i = 2;i <= n;i++){
            if(map.get(a[i]) - map.get(a[i-1]) == 1)sum ++;
            else{
                res.add(sum);
                sum = 1;
            }
        }
        res.add(sum);
        for(int i = 1;i <res.size();i++){
            int cur = res.get(i - 1);
            for(int j = i;j < res.size();j++){
                cur = cur * res.get(j);
                num += cur;
            }
        }
        num += (n + 1) * n / 2;
        System.out.println(num);
    }
}
