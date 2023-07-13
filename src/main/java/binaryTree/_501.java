package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lihongxing
 * @Date 2023/7/13 9:29
 */
public class _501 {
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (Integer integer : list) {
            int value = map.getOrDefault(integer,0) + 1;
            max = Math.max(max,value);
            map.put(integer,value);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if(map.get(integer) == max){
                res.add(integer);
            }
        }
        int[] realRes = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            realRes[i] = res.get(i);
        }
        return realRes;
    }
    public void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
