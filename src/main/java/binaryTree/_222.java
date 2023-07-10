package binaryTree;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/6/16 17:39
 */
public class _222 {
    int res = 0;

    public int dfs(TreeNode node){
        if(node == null)return 0;
        if(node.left == null && node.right == null){
            return 1;
        }
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        return Math.max(left,right);
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));;
    }

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null)return 1;
        return (countNodes(root.left)+1) + (countNodes(root.right)+1);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
