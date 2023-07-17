package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/17 9:28
 */
public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums,0,nums.length - 1);
    }
    public TreeNode getTree(int[] nums,int start,int end){
        if(start > end)return null;
        int index = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = getTree(nums,start,index - 1);
        root.right = getTree(nums,index + 1,end);
        return root;
    }
}
