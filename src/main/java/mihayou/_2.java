package mihayou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/13 21:18
 */
public class _2 {
    final static int maxn = 100000 + 5000;
    static List<Integer>[] node = new ArrayList[maxn];;
    static boolean[] used = new boolean[maxn];
    static long dfs(int root,long dep,long k){
        int node1,cnt = 0;
        if(dep == k){
            return 0;
        }

        for(int i = 0;i < node[root].size();++i){
            node1 = node[root].get(i);
            if(!used[node1]){
                used[node1] = true;
                cnt += dfs(node1,dep + 1,k);
            }
        }
        if(cnt == 0){
            return k - dep + 1;
        }else{
            return 1 + cnt;
        }
    }

    public static void main(String[] args) {
        long n,k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        int u,v;
        for(int i = 0;i < maxn;i++){
            node[i] = new ArrayList<>();
        }
        for(long i = 0;i < n - 1;++i){
            u = sc.nextInt();
            v = sc.nextInt();
            node[u].add(v);
            node[v].add(u);
        }
        for(int i = 1;i <= n;i++){
            used[i] = false;
        }
        used[1] = true;
        System.out.println(dfs(1,0,k));
    }
}
