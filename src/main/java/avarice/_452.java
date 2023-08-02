package avarice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class _452 {
    @Test
    public void test(){
        int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        int minArrowShots = findMinArrowShots(points);
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1],o2[1]) : Integer.compare(o1[0],o2[0]);
            }
        });
        int res = 1;
        for(int i = 1;i < points.length;i++){
            if(points[i][0] <= points[i-1][1]){
                points[i][0] = Math.max(points[i][0],points[i-1][0]);
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }else{
                res++;
            }
        }
        return res;
    }
    @Test
    public void test1(){
        System.out.println(2147483646 <= -2147483645);
    }

}
