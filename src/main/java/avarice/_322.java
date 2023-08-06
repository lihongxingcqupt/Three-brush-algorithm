package avarice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lihongxing
 * @Date 2023/8/6 14:21
 */
public class _322 {
    @Test
    public void test(){
        int i = coinChange(new int[]{2}, 3);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i < coins.length;i++){
            for(int j = coins[i];j <= amount;j++){
                if(dp[j - coins[i]] == Integer.MAX_VALUE)continue;
                dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
