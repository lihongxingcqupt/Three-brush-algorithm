import com.sun.xml.internal.bind.v2.TODO;

import java.util.Stack;

public class Problem3 {

    //TODO 别写测试方法了，来不及了，讲思路，和下面那个实现
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, node3, null);
        TreeNode node2 = new TreeNode(2, node1, node4);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode root = new TreeNode(6, node2, node8);
        System.out.println("递归求解");
        TreeNode result1 = find1(root);
        if (result1 != null) {
            System.out.println(result1.value);
        } else {
            System.out.println("result1 is null");
        }
    }

    public static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    };

    /*
     * 对二叉排序树进行中序遍历可以得到从小到大的序列
     * 中序遍历递归实现: 先中序遍历左子树,然后遍历根节点,中序遍历右子树
     * 本题解法:
     * 使用逆序中序遍历可以较快地得到第三大的元素
     * TODO 先逆中序遍历右子树,再读取根结点,再逆序遍历左子树
     */
    //递归写法
    private static int count = 0;
    // 关键是
    private static TreeNode find1(TreeNode root) {

        if (root != null) {
            TreeNode r1 = find1(root.right);
            if(r1 != null) {
                //已找到第三最大
                return r1;
            }
            if(count++ == 2) {
                return root;
            }
            TreeNode r2 = find1(root.left);
            if(r2 != null) {
                //已找到第三最大
                return r2;
            }
        }
        return null;
    }

}
