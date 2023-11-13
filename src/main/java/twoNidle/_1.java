package twoNidle;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/11/6 23:00
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] A = new long[100001];  // 使用一个足够大的数组来模拟无限长的序列

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            long x = sc.nextLong();

            A[l] ^= x;  // 修改左边界
            if (r + 1 < A.length) {
                A[r + 1] ^= x;  // 恢复右边界
            }
        }

        // 计算前缀异或和
        for (int i = 1; i < A.length; i++) {
            A[i] ^= A[i - 1];
        }

        for (int i = 0; i < m; i++) {
            long p = sc.nextLong();
            System.out.println(A[(int) p]);
        }
    }
}
