package meituan;

/**
 * @Author lihongxing
 * @Date 2023/9/23 10:36
 */
public class Problem1 {
    public static class LinkNode{
        public LinkNode(int val){
            this.val = val;
        }
        int val;
        LinkNode next;

        public void merge(LinkNode l2){
            mergeTwoLists(this, l2);
            l2 = null;
        }
    }
    // 穿的是地址的拷贝
    // TODO 复杂度n+m
    public static void mergeTwoLists(LinkNode l1, LinkNode l2) {
        LinkNode pre = new LinkNode(-1);
        LinkNode preHead = pre;

        LinkNode temp = l1;
        while(temp != null && l2 != null){
            if(temp.val<l2.val){
                preHead.next=temp;
                temp=temp.next;
            }else{
                preHead.next=l2;
                l2=l2.next;
            }
            preHead=preHead.next;
        }
        preHead.next = l1==null ? l2:l1;

        l1.next = pre.next.next;

    }


    private int find(int[] arr) {
        if (arr == null) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if(arr[0] < arr[arr.length - 1]){
            return arr[0];
        }
        // 二分查找凹凸的地方
        return binarySearch(arr,0,arr.length - 1);
    }
    // TODO 复杂度logn
    private int binarySearch(int[] arr,int left,int right) {
        if (left > right) {
            return -1;
        }
        if (right - left <= 1) {
            return Math.min(arr[left],arr[right]);
        }
        int mid = (left + right) / 2;
        // 说明在下坡
        if (arr[mid] < arr[left] && arr[mid] < arr[right]) {
            return binarySearch(arr,left,mid);
        }
        // 说明在爬坡
        else if (arr[mid] > arr[left] && arr[mid] > arr[right]) {
            return binarySearch(arr,mid,right);
        }
        return -1;
    }

}
