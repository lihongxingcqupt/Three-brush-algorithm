package avarice;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/7/30 12:18
 */
public class _134 {

    @Test
    public void test(){
        int i = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int start = 0;
        lo:while(true){
            int gasTemp = 0;
            boolean flag = true;
            for(int i = start;true;i++){
                gasTemp += gas[i % gas.length];
                if(i > start && i % gas.length == start){
                    break;
                }
                if(gasTemp - cost[i % gas.length] >= 0){
                    gasTemp -= cost[i % gas.length];
                }else{
                    flag = false;
                    break ;
                }
            }
            if(flag)return start;
            if(start > gas.length)return -1;
            start++;
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < gas.length;i++){
            sum += (gas[i] - cost[i]);
            min = Math.min(min,sum);
        }
        if(sum < 0)return -1;
        if(min >= 0)return 0;
        for(int i = gas.length - 1;i >= 0;i--){
            min += (gas[i] - cost[i]);
            if(min >= 0)return i;
        }
        return -1;
    }
}
