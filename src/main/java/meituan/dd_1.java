package meituan;

import java.util.Scanner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * @Author lihongxing
 * @Date 2023/9/15 19:33
 */
public class dd_1 {

    static int[] dx = {-1, 1, 0, 0}; // 上下左右四个方向的偏移量
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int result = bfs(grid, n, m);
        System.out.println(result);
    }

    static int bfs(int[][] grid, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{0, 0, 0}); // {x, y, steps}

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            if (x == n - 1 && y == m - 1) {
                return steps;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && grid[newX][newY] == 0) {
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; // 如果无法到达目标点
    }
}

