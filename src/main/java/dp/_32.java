package dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lihongxing
 * @Date 2023/8/13 12:28
 */
public class _32 {
    @Test
    public void test(){
        int i = coinChange(new int[]{186,419,83,408}, 6249);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i < coins.length;i++){
            for(int j = coins[i];j <= amount;j++){
                if(!(dp[j - coins[i]] == Integer.MAX_VALUE)){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
