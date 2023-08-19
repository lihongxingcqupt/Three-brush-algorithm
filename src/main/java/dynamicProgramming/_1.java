package dynamicProgramming;

import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/8/19 16:39
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] danciS = new String[n];
        Map<String,Integer> danciTimes = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            danciS[i] = sc.next();
        }
        int res = 0;
        int curTimes = 0;
        for(int i = 0;i < n;i++){
            if(set.contains(danciS[i]))continue;
            Integer times = danciTimes.getOrDefault(danciS[i],0);
            if(times == curTimes){
                res ++;
                set.add(danciS[i]);
                curTimes ++;
            }else{
                danciTimes.put(danciS[i],danciTimes.getOrDefault(danciS[i],0) + 1);
            }
        }
        System.out.println(res);
    }
}
