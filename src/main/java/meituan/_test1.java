package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/16 19:24
 */
public class _test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        if(nums.length == 2){
            System.out.println(Math.max(nums[0],nums[1]));
            return;
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }
        System.out.println(dp[n - 1]);
    }
}
