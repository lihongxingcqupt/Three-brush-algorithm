package binaryTree;


/**
 * @Author lihongxing
 * @Date 2023/7/16 21:16
 */
public class _450 {
    public TreeNode deleteNode(TreeNode root,int key){
        if (root == null)return root;
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode temp = root.right;
            while (temp.left != null){
                temp = temp.left;
            }
            temp.left = root.left;
            root = root.right;
        }
        return root;
    }

}
