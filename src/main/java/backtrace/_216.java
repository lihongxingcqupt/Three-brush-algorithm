package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/18 21:24
 */
public class _216 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for(int i = 1;i <= 9;i++){
            nums[i - 1] = i;
        }
        dfs(nums,0,new ArrayList<>(),k,n,0);
        return res;
    }
    public void dfs(int[] nums,int sum,List<Integer> list,int k,int target,int index){
        if(sum == target && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target || list.size() == k)return;
        for(int i = index;i < nums.length;i++){
            list.add(nums[i]);
            dfs(nums,sum += nums[i],list,k,target,i + 1);
            list.remove(list.size() - 1);
        }
    }
}
