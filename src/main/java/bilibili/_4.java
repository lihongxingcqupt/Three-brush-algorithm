package bilibili;

import sun.net.idn.Punycode;
import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/8 20:07
 */
public class _4 {
    static class TreeNode{
        public boolean color;
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        nodes[0] = new TreeNode();
        for(int i = 1;i < n;i++){
            nodes[i] = new TreeNode();
            int index = sc.nextInt() - 1;
            if(nodes[index].left == null){
                nodes[index].left = nodes[i];
            }else{
                nodes[index].right = nodes[i];
            }
        }
        for(TreeNode node : nodes){
            node.color = sc.nextInt() == 1;
        }
        System.out.println(dfs(nodes[0]));
    }
    static long mod = 1000000007;
    public static long dfs(TreeNode head){
        if(head.left == null){
            return 1;
        }
        long res = 0;
        if(head.color){
            res = (dfs(head.left) + dfs(head.right)) % mod;
        }else{
            res = (dfs(head.left) * dfs(head.right)) % mod;
        }
        head.val = (int)res;
        return res;
    }
}
