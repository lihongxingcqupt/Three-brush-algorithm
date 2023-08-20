package dp;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/20 14:12
 */
public class _1 {
    @Test
    public void test(){
//        int res = closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}});
        int res = closedIsland(new int[][]{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}});
        System.out.println(res);
    }
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    boolean shang = false;
                    boolean xia = false;
                    boolean zuo = false;
                    boolean you = false;
                    for(int k = i;k >= 0;k--){
                        if(grid[k][j] == 1){
                            shang = true;
                            break;
                        }
                    }
                    for(int k = i;k < grid.length;k++){
                        if(grid[k][j] == 1){
                            xia = true;
                            break;
                        }
                    }
                    for(int k = j;k >= 0;k--){
                        if(grid[i][k] == 1){
                            zuo = true;
                            break;
                        }
                    }
                    for(int k = j;k < grid[0].length;k++){
                        if(grid[i][k] == 1){
                            you = true;
                            break;
                        }
                    }
                    if(shang && xia && zuo && you){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
        }
        return count;
    }


    public void dfs(int[][] grid, int r, int c) {
        // 递归结束条件：如果坐标(r, c)超出网格，直接返回
        if (!inArea(grid, r, c))
            return;
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != 0)
            return;
        grid[r][c] = 2;// 标记已经遍历的格子

        dfs(grid, r - 1, c);// 上
        dfs(grid, r + 1, c);// 下
        dfs(grid, r, c - 1);// 左
        dfs(grid, r, c + 1);// 右
    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }


}
