package binaryTree;

/**
 * 翻转二叉树
 * @Author lihongxing
 * @Date 2023/6/16 16:01
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode node){
        if(node == null)return;
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        dfs(node.left);
        dfs(node.right);
    }
}
