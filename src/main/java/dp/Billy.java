package dp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/11/27 17:54
 */

public class Billy {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private int maxSum = Integer.MIN_VALUE;
    private List<Integer> maxPath = new ArrayList<>();
    public List<Integer> findMaxPathSum(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
        findMaxPathSumHelper(root, currentPath, 0);
        return maxPath;
    }
    private void findMaxPathSumHelper(TreeNode node, List<Integer> currentPath, int currentSum) {
        if (node == null) {
            return;
        }
        // 添加当前节点到路径
        currentPath.add(node.val);
        // 更新当前路径的和
        currentSum += node.val;
        // 如果是叶子节点，判断是否是最大路径
        if (node.left == null && node.right == null) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxPath = new ArrayList<>(currentPath);
            }
        }
        // 递归处理左右子树
        findMaxPathSumHelper(node.left, currentPath, currentSum);
        findMaxPathSumHelper(node.right, currentPath, currentSum);
        // 回溯，移除当前节点
        currentPath.remove(currentPath.size() - 1);
    }

    public static TreeNode transformLeftToRight(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 递归处理左右子树
        TreeNode left = transformLeftToRight(root.left);
        TreeNode right = transformLeftToRight(root.right);

        // 将左子树移到右子树
        root.left = null;
        root.right = left;

        // 找到新的右子树的最右节点，将原来的右子树接在其后
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;

        return root;
    }

}
