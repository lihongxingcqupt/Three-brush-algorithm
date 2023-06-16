package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/6/16 16:53
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.min(left,right);
    }
}
