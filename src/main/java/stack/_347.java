package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author lihongxing
 * @Date 2023/7/4 9:33
 */
public class _347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Integer key : map.keySet()) {
            pq.add(new int[]{key,map.get(key)});
        }
        int[] res = new int[k];
        for(int i = 0;i < k;i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
