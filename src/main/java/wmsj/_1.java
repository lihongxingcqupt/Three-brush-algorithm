package wmsj;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lihongxing
 * @Date 2023/8/26 18:28
 */
public class _1 {
    public int findStone (int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        int res = Integer.MIN_VALUE;
        for (Integer integer : map.keySet()) {
            if(map.get(integer) == integer){
                res = Math.max(res,integer);
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
