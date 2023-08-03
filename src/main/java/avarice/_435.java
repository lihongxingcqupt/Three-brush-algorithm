package avarice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

/**
 * @Author lihongxing
 * @Date 2023/8/2 23:03
 */
public class _435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? Integer.compare(o1[0],o2[0]) : Integer.compare(o1[1],o2[1]);
            }
        });
        int res = 0;
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1]){
                res++;
                intervals[i] = intervals[i][1] > intervals[i-1][1] ? intervals[i-1] : intervals[i];
            }
        }
        return res;
    }

    @Test
    public void test(){
        String s = "111";
        System.out.println(s.equals(111));
        HashMap map = new HashMap();
        map.get(1);
    }
}
