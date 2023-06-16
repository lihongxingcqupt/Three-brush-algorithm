package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/6/16 17:39
 */
public class _222 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int dfs(TreeNode node){
        if(node == null)return 0;
        if(node.left == null && node.right == null){
            return 1;
        }
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        return Math.max(left,right);
    }
}
