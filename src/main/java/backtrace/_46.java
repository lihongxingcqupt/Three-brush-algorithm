package backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author lihongxing
 * @Date 2023/7/22 16:54
 */
public class _46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new ArrayList<>(),new HashSet<>());
        return res;
    }
    public void dfs(int[] nums, List<Integer> list, Set<Integer> set){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!set.add(nums[i]))continue;
            list.add(nums[i]);
            dfs(nums,list,set);
            set.remove(nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
