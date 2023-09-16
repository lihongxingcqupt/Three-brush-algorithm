package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/15 19:53
 */
public class dd_2 {
    static int[] dx = {-1, 1, 0, 0}; // 上下左右四个方向的偏移量
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] isVisited;
    static int res = 0;
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
        res = Integer.MAX_VALUE;
        isVisited = new boolean[n][m];
        dfs(grid, 0, 0,0);
        System.out.println(res);
    }

    public static void dfs(int[][] grid,int x,int y,int sum){
        if(x == grid.length - 1 && y == grid[0].length - 1){
            res = Math.min(res,sum);
            return;
        }
        for(int i = 0;i < 4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !isVisited[newX][newY]){
                isVisited[newX][newY] = true;
                dfs(grid,newX,newY,sum + grid[newX][newY]);
                isVisited[newX][newY] = false;
            }
        }
    }
}
