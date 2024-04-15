package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * @Author lihongxing
 * @Date 2024/3/9 10:48
 */
public class _3_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] arr = new long[n];
        long chnegji_arr[] = new long[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            if(i == 0){
                chnegji_arr[i] = arr[i];
            }else{
                chnegji_arr[i] = chnegji_arr[i-1] * arr[i];
            }
        }
        int num_k = (int)Math.pow(10,k);
        List<List<Integer>> allCombinations = getAllCombinations(n - 1);
        for (int i = 0;i < allCombinations.size();i++){
            long temp = 0;
            int left = allCombinations.get(i).get(0);
            int right = allCombinations.get(i).get(1);
            if(left == right){
                temp = chnegji_arr[n-1] / arr[left];
            }else{
                temp = (chnegji_arr[left] / arr[left]) * (chnegji_arr[n - 1] / chnegji_arr[right]);
            }
            if(temp % num_k == 0){
                res ++;
            }
        }
        System.out.println(res);
    }

    public static List<List<Integer>> getAllCombinations(int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                combinations.add(pair);
            }
        }
        return combinations;
    }


}
