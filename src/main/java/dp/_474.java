package dp;

import java.util.HashMap;
import java.util.Map;

public class _474 {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i1 = 0;i1 < strs.length;i1++){
            String s = strs[i1];
            int zero = 0;
            int one = 0;
            for(int i = 0;i < s.length();i++){
                if(s.charAt(i) == '0'){
                    zero ++;
                }else{
                    one ++;
                }
            }
            map.put(i1,new int[]{zero,one});
        }
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i < strs.length;i++){
            int zero = map.get(i)[0];
            int one = map.get(i)[1];
            for(int j = m;j >= zero;j--){
                for(int k = n;k >= one;k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
