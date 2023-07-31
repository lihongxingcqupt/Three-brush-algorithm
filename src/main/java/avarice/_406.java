package avarice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/31 11:31
 */
public class _406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null)return null;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> resList = new ArrayList<>();
        for(int i = 0;i < people.length;i++){
            resList.add(people[i][1],people[i]);
        }
        int[][] res = new int[people.length][people[0].length];
        for(int i = 0;i < res.length;i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
