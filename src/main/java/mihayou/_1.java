package mihayou;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/13 20:52
 */
public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] pos = new int[3][2];
        for(int i = 0;i < 3;i++){
            pos[i][0] = sc.nextInt() - 1;
            pos[i][1] = sc.nextInt() - 1;
        }
        int step1 = bfs(n,m,pos[0],pos[1]);
        int step2 = bfs(n,m,pos[1],pos[2]);
        System.out.println(step1 + step2);
    }

    private static int bfs(int n, int m, int[] start, int[] end) {
        int[][] next = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int ans = 0;
        int x = start[0];
        int y = start[1];
        int[][] used = new int[n][m];
        used[x][y] = 1;
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(new int[]{x,y});
        while(!arrayDeque.isEmpty()){
            int size = arrayDeque.size();
            ans ++;
            for(int i = 0;i < size;i++){
                int[] poll = arrayDeque.poll();
                for(int j = 0;j < 4;j++){
                    int nextX = 0;
                    int nextY = 0;
                    if(poll[0] + next[j][0] == -1){
                        nextX = n - 1;
                    }else if(poll[0] + next[j][0] == n){
                        nextX = 0;
                    }else{
                        nextX = poll[0] + next[j][0];
                    }
                    if(poll[1] + next[j][1] == -1){
                        nextY = m - 1;
                    }else if(poll[1] + next[j][1] == m){
                        nextY = 0;
                    }else{
                        nextY = poll[1] + next[j][1];
                    }
                    if(nextX == end[0] && nextY == end[1]){
                        return ans;
                    }
                    if(used[nextX][nextY] == 0){
                        used[nextX][nextY] = 1;
                        arrayDeque.add(new int[]{nextX,nextY});
                    }
                }
            }
        }
        return 0;
    }
}
