package binaryTree;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/7/10 21:44
 */
public class _112 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.left = new TreeNode(13);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        System.out.println(hasPathSum(root,22));
    }
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        dfs(root,targetSum,root.val);
        return res;
    }
    public void dfs(TreeNode root,int targetSum,int sum){
        if(root == null)return;
        if(root.left == null && root.right == null){
            if(targetSum == sum){
                res = true;
            }
        }
        if(root.left != null){
            int nextSum = sum + root.left.val;
            dfs(root.left,targetSum,nextSum);
        }
        if(root.right != null){
            int nextSum = sum + root.right.val;
            dfs(root.right,targetSum,nextSum);
        }
    }
}
