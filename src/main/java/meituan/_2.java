package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/9 10:11
 */
public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextLong();
        }
        long[] sumNum = new long[n];
        long sum = 0;
        for(int i = 0;i < n;i++){
            sumNum[i] = (sum += nums[i]);
        }
        long temp = Integer.MIN_VALUE;
        for(int i = 1;i < n;i++){
            if(nums[i] < sumNum[i - 1]){
                temp = Math.max(temp,nums[i]);
            }
        }
        long allSum = Arrays.stream(nums).sum();
        if(temp == Integer.MIN_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(allSum - temp * 2);
        }

    }
}
