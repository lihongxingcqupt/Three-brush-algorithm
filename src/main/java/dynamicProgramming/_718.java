package dynamicProgramming;

/**
 * @Author lihongxing
 * @Date 2023/8/20 11:04
 */
public class _718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = 0;i < nums1.length;i++){
            for(int j = 0;j < nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
