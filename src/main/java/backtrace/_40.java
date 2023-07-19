package backtrace;

import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/7/19 9:38
 */
public class _40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,target,0,new ArrayList<>(),candidates);
        return res;
    }
    public void dfs(int sum,int target,int index,List<Integer> list,int[] candidates){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target)return;
        Set<Integer> set = new HashSet<>();
        for(int i = index;i < candidates.length;i++){
            if(!set.add(candidates[i]))continue;
            list.add(candidates[i]);
            dfs(sum + candidates[i],target,i + 1,list,candidates);
            list.remove(list.size() - 1);
        }
    }
}
