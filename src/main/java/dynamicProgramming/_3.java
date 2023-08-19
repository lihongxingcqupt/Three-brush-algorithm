package dynamicProgramming;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/19 16:53
 */
public class _3 {
    static int sum = 0;
    static int cost = 0;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] values = new int[n];
        int[] times = new int[n];
        int[][] costs = new int[m][3];
        for(int i = 0;i < n;i++){
            values[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            times[i] = sc.nextInt();
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < 3;j++){
                costs[i][j] = sc.nextInt();
            }
        }
        dfs(values,times,costs,k,0);
        System.out.println(max);
    }
    public static void dfs(int[] values,int[] times,int[][] costs,int k,int start){
        if(cost > k){
            return;
        }
        for(int i = start;i < 3;i++){
            if(costs[start][i] > 0){
                sum += values[i];
                cost += costs[start][i] + times[i];
                max = Math.max(sum,max);
            }
            dfs(values,times,costs,k,i+1);
            sum -= values[i];
            cost -= costs[start][i] + times[i];
        }
    }
}
