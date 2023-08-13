package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/13 14:55
 */
public class KEDA_3 {
    static int resNum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        for(int i = 0;i < n;i++){
            array1[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            array2[i] = sc.nextInt();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        getSubset(array1,0,res,path);
        path = new LinkedList<>();
        getSubset(array2,0,res,path);
        System.out.println(resNum);
    }
    private static void getSubset(int[] nums,int startIndex,List<List<Integer>> res,LinkedList<Integer> path){
        if(!res.contains(path)){
            resNum++;
        }
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex;i < nums.length;i++){
            path.add(nums[i]);
            getSubset(nums,i + 1,res,path);
            path.removeLast();
        }
    }
}
