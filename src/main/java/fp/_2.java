package fp;

/**
 * @Author lihongxing
 * @Date 2023/10/7 20:14
 */

import java.util.Scanner;

public class _2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int result = minOperations(s);
        System.out.println(result);
    }

    public static int minOperations(String s) {
        int n = s.length();
        int[] dp = new int[n];

        // 辅音字母
        String consonants = "bcdfghjklmnpqrstvwxyz";

        dp[0] = 0; // 初始化第一个字符的操作次数为0

        for (int i = 1; i < n; i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);

            // 如果当前字符和前一个字符都是辅音字母
            if (consonants.contains(String.valueOf(curr)) && consonants.contains(String.valueOf(prev))) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }

            // 如果当前字符和前一个字符都是元音字母
            if ("aeiou".contains(String.valueOf(curr)) && "aeiou".contains(String.valueOf(prev))) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }

            // 对于其他情况，不需要操作
        }

        return dp[n - 1];
    }
}


