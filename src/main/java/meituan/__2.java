package meituan;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/9/14 20:01
 */
public class __2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
   @Test
   public void test(){
       ListNode listNode1 = new ListNode(1);
       listNode1.next = new ListNode(2);
       listNode1.next.next = new ListNode(3);
       ListNode listNode2 = new ListNode(1);
       listNode2.next = new ListNode(2);
       listNode2.next.next = new ListNode(3);
       ListNode listNode3 = new ListNode(1);
       listNode3.next = new ListNode(2);
       listNode3.next.next = new ListNode(3);
       ListNode[] lists = new ListNode[3];
       lists[0] = listNode1;
       lists[1] = listNode2;
       lists[2] = listNode3;
       ListNode res = mergeKLists(lists);
       while(res != null){
           System.out.println(res.val);
           res = res.next;
       }
   }
   // 这里调用两个两个的，才是结果，是k个合并，todo 思路就是先写两个合并再遍历
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }


   //两个两个的合并
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
//    首先我们需要一个变量 head\textit{head}head 来保存合并之后链表的头部，你可以把 head\textit{head}head 设置为一个虚拟的头（也就是 head\textit{head}head 的 val\textit{val}val 属性不保存任何值），这是为了方便代码的书写，在整个链表合并完之后，返回它的下一位置即可。
//    我们需要一个指针 tail\textit{tail}tail 来记录下一个插入位置的前一个位置，以及两个指针 aPtr\textit{aPtr}aPtr 和 bPtr\textit{bPtr}bPtr 来记录 aaa 和 bbb 未合并部分的第一位。注意这里的描述，tail\textit{tail}tail 不是下一个插入的位置，aPtr\textit{aPtr}aPtr 和 bPtr\textit{bPtr}bPtr 所指向的元素处于「待合并」的状态，也就是说它们还没有合并入最终的链表。 当然你也可以给他们赋予其他的定义，但是定义不同实现就会不同。
//    当 aPtr\textit{aPtr}aPtr 和 bPtr\textit{bPtr}bPtr 都不为空的时候，取 val\textit{val}val 属性较小的合并；如果 aPtr\textit{aPtr}aPtr 为空，则把整个 bPtr\textit{bPtr}bPtr 以及后面的元素全部合并；bPtr\textit{bPtr}bPtr 为空时同理。
//    在合并的时候，应该先调整 tail\textit{tail}tail 的 next\textit{next}next 属性，再后移 tail\textit{tail}tail 和 *Ptr\textit{*Ptr}*Ptr（aPtr\textit{aPtr}aPtr 或者 bPtr\textit{bPtr}bPtr）。那么这里 tail\textit{tail}tail 和 *Ptr\textit{*Ptr}*Ptr 是否存在先后顺序呢？它们谁先动谁后动都是一样的，不会改变任何元素的 next\textit{next}next 指针。
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/merge-k-sorted-lists/solutions/219756/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
