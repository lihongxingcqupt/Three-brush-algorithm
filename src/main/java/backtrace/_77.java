package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/18 21:10
 */
public class _77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 1;i <= n;i++){
            nums[i - 1] = i;
        }
        dfs(nums,0,new ArrayList<>(),k);
        return res;
    }
    public void dfs(int[] nums,int index,List<Integer> list,int k){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i < nums.length;i++){
            list.add(nums[i]);
            dfs(nums,i + 1,list,k);
            list.remove(list.size() - 1);
        }
    }
}
