package meituan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }
/**
 * @Author lihongxing
 * @Date 2023/9/10 20:05
 */
public class _tx1 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(0);
        root.right.right = new TreeNode(1);
        int i = pathNumber(root);
        System.out.println(i);
    }
    int ans;
    List<List<Integer>> res = new ArrayList<>();
    public int pathNumber (TreeNode root) {
        ans = 0;
        dfs(root,0,0);
        return ans;
    }
    public void dfs(TreeNode curNode,int oneNum,int zeroNum){
        // 出口
        if(curNode.val == 0){
            zeroNum ++;
        }else{
            oneNum ++;
        }
        if(curNode.left == null && curNode.right == null){
            if(oneNum - zeroNum == 1){
                ans ++;
            }
            return;
        }
        // 递归
        if(curNode.left != null){
            dfs(curNode.left,oneNum,zeroNum);
        }
        if(curNode.right != null){
            dfs(curNode.right,oneNum,zeroNum);
        }
    }
}
