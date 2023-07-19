package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/19 9:32
 */
public class _39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0,new ArrayList<>(),0);
        return res;
    }
    public void dfs(int[] candidates,int target,int sum,List<Integer> list,int index){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum >= target)return;
        for(int i = index;i < candidates.length;i++){
            list.add(candidates[i]);
            dfs(candidates,target,sum + candidates[i],list,i);
            list.remove(list.size() - 1);
        }
    }
}
