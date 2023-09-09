package jd;

/**
 * @Author lihongxing
 * @Date 2023/9/2 11:27
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class __1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l1 = scanner.nextLong();
        long r1 = scanner.nextLong();
        long l2 = scanner.nextLong();
        long r2 = scanner.nextLong();
        long l3 = scanner.nextLong();
        long r3 = scanner.nextLong();
        long[][] nums = new long[][]{{l1,r1},{l2,r2},{l3,r3}};
        Arrays.sort(nums, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0],o2[0]);
            }
        });
        long result = findMaxSum(nums);
        System.out.println(result);
    }

    public static long findMaxSum(long[][] nums) {
        long maxSum = -1;
        // 选择 1，2
        if(nums[0][1] >= nums[1][0]){
            maxSum = Math.max(maxSum,nums[0][1] * 2);
        }
        // 选择1，3
        if(nums[0][1] >= nums[2][0]){
            maxSum = Math.max(maxSum,nums[0][1] * 2);
        }
        // 选择2，3
        if(nums[1][1] >= nums[2][0]){
            maxSum = Math.max(maxSum,nums[1][1] * 2);
        }
        return maxSum;
    }
}
