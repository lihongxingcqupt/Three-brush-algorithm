package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/10 11:11
 */
public class _44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for(int i = 0;i < n;i++){
            nums1[i] = sc.nextInt();
        }
        for(int i = 0;i < m;i++){
            nums2[i] = sc.nextInt();
        }
        int res = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(isLeastCommonMultiple(nums1[i],nums2[j],k)){
                    res ++;
                }
            }
        }
        System.out.println(res);
    }
    public static boolean isLeastCommonMultiple(int num1, int num2, int k) {
        int gcd = findGCD(num1, num2);
        int lcm = (num1 * num2) / gcd; // 计算最小公倍数

        return k == lcm;
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}
