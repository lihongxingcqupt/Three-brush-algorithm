package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/12 9:33
 */
public class _530 {
    public int getMinimumDifference(TreeNode root) {
        if(root == null)return Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left != null){
            left = leftDfs(root.left);
        }
        if(root.right != null){
            right = rightDfs(root.right);
        }
        int res = Math.min(Math.abs(root.val - left),Math.abs(root.val - right));
        return Math.min(getMinimumDifference(root.left),Math.min(getMinimumDifference(root.right),res));

    }
    public int leftDfs(TreeNode root){
        if(root.right == null)return root.val;
        return leftDfs(root.right);
    }
    public int rightDfs(TreeNode root){
        if(root.left == null)return root.val;
        return rightDfs(root.left);
    }
}
