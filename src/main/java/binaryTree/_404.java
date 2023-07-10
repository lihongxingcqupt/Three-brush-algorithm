package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/10 21:13
 */
public class _404 {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,false);
        return res;
    }
    public void dfs(TreeNode root,boolean isLeft){
        if(root == null)return;
        if(root.left == null && root.right == null && isLeft){
            res += root.val;
        }
        dfs(root.left,true);
        dfs(root.right,false);
    }
}
