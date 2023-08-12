package mt;

import java.util.ArrayList;
import java.util.Scanner;

public class _5 {

    static long[] a;
    static int n;
    static ArrayList<Integer>[] v;
    static long[][] f;

    static boolean check(int x, int y) {
        long val = a[x] * a[y];
        long l = 0, r = (long) 1e9 + 2;
        while (l < r) {
            long mid = l + r >> 1;
            if (mid * mid < val) l = mid + 1;
            else r = mid;
        }
        return l * l == val;
    }

    static void dfs(int u, int fa) {
        // get u, 0
        for (int x : v[u]) {
            if (x != fa) {
                dfs(x, u);
                f[u][0] += Math.max(f[x][0], f[x][1]);
            }
        }
        // get u, 1
        for (int x : v[u]) {
            if (x != fa && check(x, u)) {
                long tmp = f[u][0] - Math.max(f[x][0], f[x][1]) + f[x][0] + 2;
                f[u][1] = Math.max(f[u][1], tmp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new long[n + 1];
        v = new ArrayList[n + 1];
        f = new long[n + 1][2];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
            v[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            v[x].add(y);
            v[y].add(x);
        }

        dfs(1, 0);
        System.out.println(Math.max(f[1][0], f[1][1]));
    }
}
