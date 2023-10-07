//package meituan;
//
//import avarice.ListNode;
//import org.junit.Test;
//
///**
// * @Author lihongxing
// * @Date 2023/9/23 15:12
// */
//public class reverseLinknode {
//    // TODO 递归
//    public ListNode reverseList(ListNode head) {
////        if (head == null || head.next == null) {
////            return head;
////        }
////        ListNode newHead = reverseList(head.next);
////        head.next.next = head;
////        head.next = null;
////        return newHead;
//        return null;
//    }
//
//
//    class Solution {
//        public ListNode mergeKLists(ListNode[] lists) {
//            ListNode ans = null;
//            if(lists == null)return null;
//            for (int i = 0; i < lists.length; ++i) {
//                ans = mergeTwoLists(ans, lists[i]);
//            }
//            return ans;
//        }
//        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 TODO 没有
//        public ListNode mergeTwoLists(ListNode a, ListNode b) {
//            if (a == null || b == null) {
//                return a != null ? a : b;
//            }
//            ListNode head = new ListNode(0);
//            ListNode tail = head, aPtr = a, bPtr = b;
//            while (aPtr != null && bPtr != null) {
//                if (aPtr.val < bPtr.val) {
//                    tail.next = aPtr;
//                    aPtr = aPtr.next;
//                } else {
//                    tail.next = bPtr;
//                    bPtr = bPtr.next;
//                }
//                tail = tail.next;
//            }
//            tail.next = (aPtr != null ? aPtr : bPtr);
//            return head.next;
//        }
//    }
//
//
//
//
//
//
//    @Test
//    public void test(){
//
//        System.out.println(rob(new int[]{1,2,3,1}));
//    }
//    // TODO 常量，所以是    o1
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0];
//        }
//        int first = nums[0], second = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < length; i++) {
//            int temp = second;
//            second = Math.max(first + nums[i], second);
//            first = temp;
//        }
//        return second;
//    }
//
//}
