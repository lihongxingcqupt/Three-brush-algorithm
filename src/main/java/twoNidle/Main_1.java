package twoNidle;

/**
 * @Author lihongxing
 * @Date 2023/10/18 15:28
 */

import java.util.Scanner;


import java.util.Scanner;
public class Main_1 {
    //所以动态转移方程为
    //dp[k][n]=dp[k-1][(n-1+10)%10]+dp[k-1][(n+1)%10]
    //其中，第一维为具体步数，第二维为位置。取模保证范围在0-n-1，初始n=0,从0号位置开始。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int N = 10;
        int[][] dp = new int[n + 1][N];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {  // 步数
            for (int j = 0; j < N; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + N) % N] + dp[i - 1][(j + 1) % N];
            }
        }

        System.out.println(dp[n][0]);
    }














    public int maxProfit(int prices[]) {
        // 暂时保存最小的股价
        int minprice = Integer.MAX_VALUE;
        // 最大利润
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                // 如果当前股价更低，那么更新最低股价
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                // 如果当前能获利，那就算能获利多少钱并更新最大利润
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
//        时间复杂度：O(n)，只需要遍历一次。
//        空间复杂度：O(1)，只使用了常数个变量
    }























    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
//            这两行调换顺序也是可以的
//            状态从持有现金（cash）开始，到最后一天我们关心的状态依然是持有现金（cash）；
//            每一天状态可以转移，也可以不动。状态转移用下图表示：
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            现金-买股票的钱，买股票，
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}


