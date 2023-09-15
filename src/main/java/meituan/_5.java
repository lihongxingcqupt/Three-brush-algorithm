import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _5 {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] happiness = new int[n];
        for (int i = 0; i < n; i++) {
            happiness[i] = scanner.nextInt();
        }
        long[] chang = new long[n + 1];
        int changTemp = 0;
        for(int i = 1;i <= n;i++){
            chang[i] = changTemp;
            changTemp += i;
        }
        long sum = Arrays.stream(happiness).sum();
        long jian = 0;
        for(int i = 1;i <= n;i++){
            res.clear();
            getZuhe(n,i,1,0,new ArrayList<>());
            jian = Long.MAX_VALUE;
            for (List<Integer> list : res) {
                long jianTemp = 0;
                for (Integer curChang : list) {
                    jianTemp += chang[curChang];
                }
                jian = Math.min(jian,jianTemp);
            }
            if(sum - jian >= x){
                System.out.println(i);
                return;
            }
        }
    }



    private static void getZuhe(int n, int k,int index, int sum, List<Integer> list) {
        if(sum == n && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size() >= k)return;
        for(int i = index;i <= n;i++){
            list.add(i);
            sum += i;
            getZuhe(n,k,i,sum,list);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
