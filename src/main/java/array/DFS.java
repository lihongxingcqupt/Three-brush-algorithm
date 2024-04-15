package array;


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lihongxing
 * @Date 2023/12/14 16:46
 */
public class DFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> dfs_list = new ArrayList<Integer>();

    /**
     * 递归方法实现 二叉树的深度优先遍历 DFS
     * @param root
     */
//    public void dfs1(TreeNode root){
//
//        if(root == null)
//            return;
//        dfs_list.add(root.val);
//        if(root.left != null)
//            dfs(root.left);
//        if(root.right != null)
//            dfs(root.right);
//    }



    /**
     * 非递归方法实现 二叉树的深度优先遍历 DFS
     * @param root
     */
    public void dfs(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            dfs_list.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
    }



}
