package linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lihongxing
 * @Date 2023/6/13 21:28
 */
public class _141 {
    // 法1：通过set判断重复
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 法2：快慢指针，追上则说明有环
    public boolean hasCycle2(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != fast){
            if(slow == null || fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
