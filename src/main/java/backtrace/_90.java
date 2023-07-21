package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/21 9:30
 */
public class _90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums,int index,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = index;i < nums.length;i++){
            if(i != index && nums[i] == nums[i-1])continue;
            list.add(nums[i]);
            dfs(nums,i + 1,list);
            list.remove(list.size() - 1);
        }
    }

}
