package dp;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/8/13 12:54
 */
public class _198 {
    @Test
    public void test(){
        rob(new int[]{1,2,3,1});
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
