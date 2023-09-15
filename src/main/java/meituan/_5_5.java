package meituan;

/**
 * @Author lihongxing
 * @Date 2023/9/10 11:27
 */
import java.util.Scanner;

public class _5_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] happiness = new int[n];
        for (int i = 0; i < n; i++) {
            happiness[i] = scanner.nextInt();
        }

        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + happiness[i - 1];
        }

        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + (prefixSum[i] - prefixSum[i - j]) * j);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] <= x) {
                System.out.println(i);
                return;
            }
        }
    }
}

