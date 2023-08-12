package mt;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/12 10:49
 */
public class _3 {
    static long[][] v = new long[1001][1001];
    static long[] h = new long[1001];
    static long[] w = new long[1001];
    public static void main(String[] args) {
        long n,m,sum = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m= sc.nextInt();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                v[i][j] = sc.nextInt();
                w[i] += v[i][j];
                h[j] += v[i][j];
                sum += v[i][j];
            }
        }
        long minn = 0x3f3f3f3f;
        for(int i = 1;i < n;i++){
            h[i] += h[i-1];
            minn = Math.min(minn,Math.abs(sum - 2* h[i]));
        }
        for(int i = 1;i < m;i++){
            w[i] += w[i-1];
            minn = Math.min(minn,Math.abs(sum - 2 * w[i]));
        }
        System.out.println(minn);
    }
}
