package binaryTree;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/6/16 17:09
 */
public class _111 {
    @Test
    public void test(){
        TreeNode root = new TreeNode();
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(2);
        root.right.right.right.right = new TreeNode(2);
        minDepth(root);
    }
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left != null){
            left = Math.min(left,minDepth(root.left) + 1);
        }
        if(root.right != null){
            right = Math.min(right,minDepth(root.right) + 1);
        }
        return Math.min(left,right);
    }
}
