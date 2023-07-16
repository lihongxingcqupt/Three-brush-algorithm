package binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/16 21:37
 */
public class _669 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        trimBST(root,1,2);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)return null;
        if(root.val < low){
            return trimBST(root.right,low,high);
        }
        if(root.val > high){
            return trimBST(root.left,low,high);
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
