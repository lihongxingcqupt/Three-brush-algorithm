package backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author lihongxing
 * @Date 2023/7/21 9:38
 */
public class _491 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums,int index,List<Integer> list){
        if(list.size() > 1)res.add(new ArrayList<>(list));
        Set<Integer> set = new HashSet<>();
        for(int i = index;i < nums.length;i++){
            if(set.add(nums[i])){
                if(list.size() == 0 || nums[i] >= list.get(list.size() - 1)){
                    list.add(nums[i]);
                    dfs(nums,i + 1,list);
                    list.remove(list.size() - 1);
                }else{
                    continue;
                }
            }
        }
    }
}
