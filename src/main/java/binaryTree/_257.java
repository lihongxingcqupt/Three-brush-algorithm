package binaryTree;



import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/6/16 17:54
 */
public class _257 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(37);
        root.left = new TreeNode(-34);
        root.right = new TreeNode(-48);
        root.left.right = new TreeNode(-100);
        root.right.left = new TreeNode(-100);
        root.right.right = new TreeNode(48);
        root.right.right.left = new TreeNode(-54);
        root.right.right.left.left = new TreeNode(-71);
        root.right.right.left.right = new TreeNode(-22);
        root.right.right.left.right.right = new TreeNode(-8);
        binaryTreePaths(root);
    }
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)return res;
        dfs(root,new StringBuilder());
        return res;
    }
    public void dfs(TreeNode node,StringBuilder path){
        if(node == null)return;
        if(node.left == null && node.right == null){
            res.add(path.append(node.val).toString());
            path.delete(path.lastIndexOf(">")+1,path.length());
            return;
        }
        path.append(node.val+"->");
        dfs(node.left,path);
        dfs(node.right,path);
        path.delete(path.lastIndexOf(node.val + ""),path.length());
    }
}
