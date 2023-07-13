package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/13 9:49
 */
public class _501_1 {
    TreeNode pre = null;
    int maxVal = 0;
    List<Integer> resList = new ArrayList<>();
    int count = 0;
    public int[] findMode(TreeNode root) {
        getCount(root);
        int[] res = new int[resList.size()];
        for(int i = 0;i < resList.size();i++){
            res[i] = resList.get(i);
        }
        return res;
    }
    public void getCount(TreeNode root){
        if(root == null)return;
        getCount(root.left);
        if(pre == null || pre.val != root.val){
            count = 1;
        }else{
            count ++;
        }
        if(count > maxVal){
            resList.clear();
            resList.add(root.val);
            maxVal = count;
        }else if(count == maxVal){
            resList.add(root.val);
        }
        pre = root;
        getCount(root.right);
    }
}
