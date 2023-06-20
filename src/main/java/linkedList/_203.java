package linkedList;

/**
 * @Author lihongxing
 * @Date 2023/6/19 15:36
 */
public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                cur = cur.next;
                pre = pre.next;
            }

        }
        return dummyNode.next;
    }
}
