package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/6/16 17:54
 */
public class _257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

    }
    public void dfs(TreeNode node,StringBuilder path){
        if(node == null){
            res.add(path.toString());
        }
        path.append(node.val);
    }
}
