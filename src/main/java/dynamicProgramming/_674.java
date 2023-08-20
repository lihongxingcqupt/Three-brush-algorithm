package dynamicProgramming;

/**
 * @Author lihongxing
 * @Date 2023/8/20 11:01
 */
public class _674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1;i < nums.length;i++){
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
