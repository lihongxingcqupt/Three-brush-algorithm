public class _333 {
    public static int countCuteStrings(int n) {
        final int MOD = (int) (1e9) + 7;
        int[][] dp = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1] + dp[i - 1][j - 1]) % MOD;
                }
            }
        }

        return dp[n][3];
    }

    public static void main(String[] args) {
        int n = 4;
        int result = countCuteStrings(n);
        System.out.println(result); // Output: 3
    }
}