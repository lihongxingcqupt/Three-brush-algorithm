package mihayou;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
 * @Author lihongxing
 * @Date 2023/8/13 21:39
 */
public class _2_1 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),k = sc.nextInt();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(1);
        root.layer = 0;
        map.put(1,root);
        for(int i = 0;i < n - 1;i++){
            int num1 = sc.nextInt(),num2 = sc.nextInt();
            TreeNode node = new TreeNode(num2);
            node.layer = map.get(num1).layer + 1;
            map.get(num1).children.add(node);
            map.put(num2,node);
        }
        dfs(root,k);
        System.out.println(count);
    }

    private static void dfs(TreeNode root, int k) {
        if(root.layer < k){
            count++;
            if(root.children.size() == 0){
                count ++;
            }else{
                for(TreeNode node :root.children){
                    dfs(node,k);
                }
            }
        }else if(root.layer == k){
            count ++;
        }
    }
}
class TreeNode{
    int val;
    int layer;
    List<TreeNode> children = new ArrayList<>();
    public TreeNode(int val) {
        this.val = val;
    }
}
