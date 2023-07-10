package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/10 21:37
 */
public class _513 {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (deque != null && !deque.isEmpty()){
            list.clear();
            int len = deque.size();
            for(int i = 0;i < len;i++){
                TreeNode cur = deque.pollFirst();
                list.add(cur.val);
                if(cur.left != null){
                    deque.addLast(cur.left);
                }
                if(cur.right != null){
                    deque.addLast(cur.right);
                }
            }
        }
        return list.get(0);
    }
}
