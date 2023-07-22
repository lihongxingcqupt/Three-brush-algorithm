package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * @Author lihongxing
 * @Date 2023/7/22 17:04
 */
public class _47 {
    boolean[] isUsed;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(new ArrayList<>(),nums);
        return res;
    }
    public void dfs(List<Integer> list,int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(isUsed[i] || (i > 0 && !isUsed[i - 1] && nums[i] == nums[i-1]))continue;
            isUsed[i] = true;
            list.add(nums[i]);
            dfs(list,nums);
            isUsed[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
