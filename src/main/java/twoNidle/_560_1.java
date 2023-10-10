package twoNidle;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/10/8 14:23
 */
public class _560_1 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] nums = new long[n];
        // 读入数据
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        // 前缀记录表
        Map<BigInteger, Integer> countMap = new HashMap<>();
        // 前缀积
        BigInteger prefixProduct = new BigInteger(String.valueOf(1));
        long count = 0;

        for (int i = 0; i < n; i++) {
            prefixProduct = prefixProduct.multiply(new BigInteger(String.valueOf(nums[i])));
            BigInteger remainder = prefixProduct.mod(new BigInteger(String.valueOf(k)));
            if (remainder.equals(new BigInteger(String.valueOf(0)))) {
                // 本身就是那就 + 1
                count++;
            }
            BigInteger complement = (remainder.subtract(new BigInteger(String.valueOf(k)))).mod(new BigInteger(String.valueOf(k)));
            count += countMap.getOrDefault(complement, 0);
            countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
        }

        System.out.println(count);
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long k = scanner.nextLong();
//        long[] nums = new long[n];
//        // 读入数据
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextLong();
//        }
//        int res = 0;
//        for(int i = 0;i < nums.length;i++){
//            if(nums[i] % k == 0)res ++;
//            BigInteger sum = new BigInteger(String.valueOf(nums[i]));
//            for(int j = i + 1;j < nums.length;j++){
//                sum = sum.multiply(new BigInteger(String.valueOf(nums[j])));
//                if(sum.mod(new BigInteger(String.valueOf(k))).equals(new BigInteger(String.valueOf(0))))res ++;
//            }
//        }
//        System.out.println(res);
//    }
}
