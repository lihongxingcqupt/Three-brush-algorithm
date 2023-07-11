package binaryTree;

/**
 * @Author lihongxing
 * @Date 2023/7/11 9:38
 */
public class _645 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }
    public TreeNode dfs(int[] nums,int start,int end){
        if(start > end)return null;
        int index = start;
        int maxVal = -1;
        int maxIndex = -1;
        for(;index <= end;index++){
            if(nums[index] > maxVal){
                maxVal = nums[index];
                maxIndex = index;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = dfs(nums,start,maxIndex - 1);
        root.right = dfs(nums,maxIndex + 1,end);
        return root;
    }

}
