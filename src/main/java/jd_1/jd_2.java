package jd_1;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/23 19:53
 */
public class jd_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] targets = new long[n];
        for (int i = 0; i < n; i++) {
            targets[i] = sc.nextLong();
        }
        int res = minOps(targets);
        System.out.println(res);
    }

    // 合并两个排序号的数组
    //    private static int minOps(long[] targets) {
//        int res = 0;
//        int lastIndex = 0;
//        for(int i = 2;i < targets.length;i++){
//            if(targets[i - 2] < targets[i - 1] && targets[i - 1] < targets[i]){
//                res ++;
//                i += 2;
//            }
//            lastIndex = i;
//        }
//        lastIndex -= 2;
//        if(lastIndex < targets.length && lastIndex + 1 < targets.length && lastIndex + 2 < targets.length){
//            if(targets[lastIndex] < targets[lastIndex + 1] && targets[lastIndex + 1] < targets[lastIndex + 2]){
//                if(targets[lastIndex] > targets[lastIndex - 1] && targets[lastIndex - 1] > targets[lastIndex - 2]){
//                    res ++;
//                }
//            }
//        }
//        return res;
//    }
    private static int minOps(long[] targets) {
        int res = 0;
        for (int i = 2; i < targets.length; ) {
            if (targets[i - 2] < targets[i - 1] && targets[i - 1] < targets[i]) {
                res++;
                targets[i] = targets[i - 1];

                i += 2;
            } else {
                i++;
            }
        }
        return res;
    }

    // TODO m和n就是长度
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null){
            return nums1 == null ? nums2 : nums1;
        }
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
        return null;
    }

}
