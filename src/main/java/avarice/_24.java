package avarice;


/**
 * @Author lihongxing
 * @Date 2023/8/6 14:59
 */
public class _24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        return pre;
    }
}
