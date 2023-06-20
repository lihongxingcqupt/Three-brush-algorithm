package linkedList;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lihongxing
 * @Date 2023/6/19 20:34
 */
public class _24 {
    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapPairs(head);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next.next;
            pre.next = cur.next;
            pre.next.next = cur;
            cur.next = temp;
            pre = cur;
            cur = cur.next;
        }
        return dummyNode.next;
    }
    @Test
    public void test(){
        int i = longestArithSeqLength(new int[]{20,1,15,3,10,5,8});
        System.out.println(i);
    }
    public int longestArithSeqLength(int[] nums) {
        int res = 0;
        int[][] dp = new int[nums.length][501 * 2];
        for(int i = 0;i < nums.length;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i = 1;i < nums.length;i++) {
            for (int j = 0; j < i; j++) {
                int gap = nums[i] - nums[j] + 500;
                dp[i][gap] = Math.max(dp[i][gap], dp[j][gap] + 1);
                res = Math.max(res, dp[i][gap]);
            }
        }
        return res;
    }
}
