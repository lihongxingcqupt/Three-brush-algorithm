package jd_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/28 19:38
 */
public class _2 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] nums = new int[]{a, b, c};
        dfs(1,nums,0,n);
        long count = res.stream().distinct().count();
        System.out.println(count);
    }

    private static void dfs(int op, int[] nums, int index,int n) {
        if(op > n)return;
        if (nums[index] <= 0) {
            return;
        }
        if(canMakeTrible(nums)){
            res.add(new String(nums[0] + "" + nums[1] +""+nums[2]));
        }
        for(int i = 0;i < 3;i++){
            nums[i] = nums[i] - op;
            dfs(op + 1,nums,i,n);
            nums[i] = nums[i] + op;
        }
    }

    private static boolean canMakeTrible(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        } else return (a + b) > c && (a + c) > b && (b + c) > a;
    }
}



