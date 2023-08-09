package dp;

import org.junit.Test;

import java.util.Arrays;

public class _494 {
    @Test
    public void test(){
        findTargetSumWays(new int[]{1},1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if((sum + target) % 2 != 0)return 0;
        target = (sum + target) / 2;
        if(target < 0)return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0;i < nums.length;i++){
            for(int j = target;j >= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
