package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/11 9:22
 */
public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(0,inorder.length - 1,0,inorder.length - 1,inorder,postorder);
    }
    public TreeNode dfs(int start,int end,int start1,int end1, int[] inorder,int[] postorder){
        if(start > end || start1 > end1){
            return null;
        }
        int rootVal = postorder[end1];
        TreeNode root = new TreeNode(rootVal);
        int index = start;
        for(;index <= end;index++){
            if(inorder[index] == rootVal){
                break;
            }
        }
        int len = index - start - 1;
        root.left = dfs(start,index - 1,start1,start1 + len,inorder,postorder);
        root.right = dfs(index + 1,end,start1 + len + 1,end1- 1,inorder,postorder);
        return root;
    }
}
