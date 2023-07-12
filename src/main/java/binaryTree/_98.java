package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/12 9:26
 */
public class _98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        return leftIsDown(root.left,root.val) && rightIsUp(root.right,root.val) && isValidBST(root.left) && isValidBST(root.right);
    }
    public boolean leftIsDown(TreeNode node,int val){
        if(node == null)return true;
        if(node.val >= val){
            return false;
        }
        return leftIsDown(node.left,val) && leftIsDown(node.right,val);
    }
    public boolean rightIsUp(TreeNode node,int val){
        if(node == null)return true;
        if(node.val <= val){
            return false;
        }
        return rightIsUp(node.left,val) && rightIsUp(node.right,val);
    }
}
