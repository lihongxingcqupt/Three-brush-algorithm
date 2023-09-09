import java.util.Scanner;

public class __3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cake = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cake[i][j] = scanner.nextInt();
            }
        }
        int result = getMinDifference(cake);
        System.out.println(result);
    }

    public static int getMinDifference(int[][] cake) {
        int n = cake.length;
        int m = cake[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int totalSum = 0; // 总美味度之和
        // 计算总美味度之和，并初始化dp数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += cake[i][j];
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + cake[i][j];
            }
        }
        int minDifference = Integer.MAX_VALUE;
        // 遍历所有可能的正方形边长
        for (int len = 1; len <= Math.min(n, m); len++) {
            // 遍历所有起始位置
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= m; j++) {
                    int sum1 = dp[i + len][j + len] - dp[i][j + len] - dp[i + len][j] + dp[i][j]; // 小红吃的蛋糕美味度之和
                    int sum2 = totalSum - sum1; // 小紫吃的蛋糕美味度之和
                    int difference = Math.abs(sum1 - sum2);
                    minDifference = Math.min(minDifference, difference);
                }
            }
        }
        return minDifference;
    }
}
