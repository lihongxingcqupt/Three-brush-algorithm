package array;

/**
 * https://leetcode.cn/problems/binary-search/
 * @Author lihongxing
 * @Date 2023/6/11 13:29
 */


public class _704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
