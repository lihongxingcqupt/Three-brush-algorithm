package linkedList;


import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/6/19 16:08
 */
public class _206 {
    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = null;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        ListNode dummyNode = new ListNode(2);
        head.next = dummyNode;
        dummyNode = null;
    }
}
