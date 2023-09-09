import java.util.*;


public class soulution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 
     * @return int整型
     */
    public int cntOfTrees (int n) {

        long[] dp = new long[n+1];

        if(n == 1||n==3) {
            return 1;
        }
        if(n == 2) {
            return 0;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        for(int i =4; i <= n; i++) {
            long tmp = 0;
            for(int j = 1; j <= i-1; j++) {
                long left = dp[j];
                long right = dp[i - 1 - j];
                long aa = left * right;
//                aa %= 1000000007;
                tmp += aa;
//                tmp %= 1000000007;
            }
//            dp[i] = tmp % 1000000007;
            dp[i] = tmp;
        }
        long a = 1000000000 + 7;
        return (int)(dp[n] % a);

    }
}