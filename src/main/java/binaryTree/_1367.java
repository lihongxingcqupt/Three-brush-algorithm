package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/8/5 17:44
 */
public class _1367 {
    boolean res = false;
    public boolean isSubPath(ListNode head, TreeNode root) {
        dfs1(head,root);
        return res;
    }
    public boolean dfs(ListNode curNode,TreeNode treeNode){
        if(curNode == null)return true;
        if(treeNode == null)return false;
        if(treeNode.val == curNode.val){
            return dfs(curNode.next,treeNode.left) || dfs(curNode.next,treeNode.right);
        }else{
            return false;
        }
    }
    public void dfs1(ListNode curNode,TreeNode treeNode){
        if(treeNode == null)return;
        if(dfs(curNode,treeNode)){
            res = true;
            return;
        }
        dfs1(curNode,treeNode.left);
        dfs1(curNode,treeNode.right);
    }
}
