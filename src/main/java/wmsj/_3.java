package wmsj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/8/26 18:53
 */
public class _3 {
    @Test
    public void test(){
        int j = 1/ 0;
        int i = treasureGame(new int[]{6,2,3,4,5,5});
        System.out.println(i);
    }
    public int treasureGame (int[] treasureValue) {
        List<Integer> list = new ArrayList<>();
        for (int i : treasureValue) {
            list.add(i);
        }
        int res = 0;
        while(list.size() > 1){
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            int mid = 1;
            int tempSum = 0;
            int curMid = 0;
            boolean flag = false;
            int max = 0;
            while(mid < list.size()){


                for(int i = 0;i < mid;i++){
                    tempSum += list.get(i);
                }
                int tempMin = Math.min(tempSum,sum - tempSum);
                if(tempMin > max){
                    curMid = mid;
                    flag = tempSum > sum - tempSum ? true : false;
                    max = tempMin;
                }
                tempSum = 0;
                mid ++;
            }
            int temNewSum = 0;
            if(flag){
                //左大右小
                for(int i = curMid;i < list.size();i++){
                    res += list.get(i);
                }
                List<Integer> tempList = new ArrayList<>();
                for (Integer integer : list) {
                    tempList.add(integer);
                }
                list.clear();
                for(int i = curMid;i < tempList.size();i++){
                    list.add(tempList.get(i));
                }
            }else{
                //左小右大
                for(int i = 0;i < curMid;i++){
                    res += list.get(i);
                }
                List<Integer> tempList = new ArrayList<>();
                for (Integer integer : list) {
                    tempList.add(integer);
                }
                list.clear();
                for(int i = 0;i < curMid;i++){
                    list.add(tempList.get(i));
                }
            }
        }
        return res;
    }
}
