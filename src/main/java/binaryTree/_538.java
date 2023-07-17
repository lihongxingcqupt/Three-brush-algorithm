package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/17 9:36
 */
public class _538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    public void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.right);
        root.val += sum;
        sum += root.val;
        dfs(root.left);
    }

}
