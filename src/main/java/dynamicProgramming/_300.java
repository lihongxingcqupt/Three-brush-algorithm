package dynamicProgramming;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/8/19 15:16
 */
public class _300 {
    @Test
    public void test(){
        int i = lengthOfLIS(new int[]{4,10,4,3,8,9});

    }
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1;i < nums.length;i++){
            int max = 1;
            for(int j = 0;j < i;j++){
                max = Math.max(max,nums[i] > nums[j] ? dp[j] + 1 : 1);
            }
            dp[i] = max;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
