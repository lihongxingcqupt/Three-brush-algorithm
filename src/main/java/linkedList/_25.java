package linkedList;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;
/**
 * @Author lihongxing
 * @Date 2023/6/20 17:32
 */
public class _25 {
//        public static void main(String[] args) {
//            List<Integer> list1 = new ArrayList<>();
//            list1.add(1);
//            list1.add(2);
//            list1.add(3);
//            List<Integer> list2 = new ArrayList<>();
//            list2.add(4);
//            list2.add(5);
//            list2.add(6);
//            List<List<Integer>> input = new ArrayList<>();
//            input.add(list1);
//            input.add(list2);
//            int[][] res = getArray(input);
//            for(int i = 0;i < res.length;i++){
//                for(int j = 0;j < res[0].length;j++){
//                    System.out.print(res[i][j] + "   ");
//                }
//            }
//        }
        // m个大小为n的有序数组合并成一个大小为m*n的有序数组,输入是m个有序数组
//        public static int[][] getArray(List<List<Integer>> input){
//            int m = input.size();
//            int n = input.get(0).size();
//            // 返回数组
//            int[][] res = new int[m][n];
//            // 优先队列
//            Queue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);
//            int[] index = new int[m + 1];
//            int num = 0;
//            while(num < m * n){
//                int min = 0;
//                for(int i = 1;i <= m;i++){
//                    if(!queue.isEmpty() && queue.peek() < input.get(i).get(index[i])){
//                        index[i] ++;
//                        min = i;
//                        queue.add(input.get(i).get(index[i]));
//                    }
//                }
//                min = 0;
//                int row = num / m;
//                int col = num % n;
//                if(!queue.isEmpty()){
//                    res[row][col] = queue.poll();
//                }
//                num++;
//            }
//            return res;
//        }
    @Test
    public void test2(){
//        bigIntAdd("99","99");
        bigIntAdd("778","7788");
    }
    public void bigIntAdd(String s1,String s2){
        int gap = 0;
        StringBuilder sb = new StringBuilder();
        int index1 = s1.length() - 1;
        int index2 = s2.length() - 1;
        while (index2 >= 0 && index1 >= 0){
            int s1Int = s1.charAt(index1) - '0';
            int s2Int = s2.charAt(index2) - '0';
            int cur = (s1Int + s2Int + gap) % 10;
            if(s1Int + s2Int + gap >= 10)gap = 1;
            sb.append(cur);
            index1 --;
            index2 --;
        }
        while (index1 >= 0){
            int s1Int = s1.charAt(index1) - '0';
            int cur = s1Int +  gap - 10;
            if(s1Int + gap >= 10)gap = 1;
            sb.append(cur);
            index1 --;
        }
        while (index2 >= 0){
            int s1Int = s2.charAt(index2) - '0';
            int cur = s1Int +  gap - 10;
            if(s1Int + gap >= 10)gap = 1;
            sb.append(cur);
            index2--;
        }
        if(gap > 0){
            sb.append(gap);
        }
        System.out.println(new String(sb.reverse()));
    }

}
