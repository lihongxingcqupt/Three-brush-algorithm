package bilibili;

import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/9/8 19:55
 */
public class _3 {
    static final int mod = 1000000007;
    static Map<Integer,Integer> map = new HashMap<>();
    static List<Integer>[] vec = new ArrayList[50001];
    static int dfs(int root){
        if(vec[root].size() == 0){
            return 1;
        }
        long l = dfs(vec[root].get(0));
        long r = dfs(vec[root].get(1));
        if(map.get(root) == 1){
            return (int)(l + r) % mod;
        }
        return (int)(l % mod * r % mod) % mod;
    }
    public static void main(String[] args) {
        for(int i = 0;i < vec.length;i++){
            vec[i] = new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);
        int n,d;
        n = sc.nextInt();
        for(int i = 2;i <= n;i++){
            d = sc.nextInt();
            vec[d].add(i);
        }
        for(int i = 1;i <= n;i++){
            d = sc.nextInt();
            map.put(i,d);
        }
        System.out.println(dfs(1));
    }
}
