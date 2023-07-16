package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/16 21:08
 */
public class _701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
