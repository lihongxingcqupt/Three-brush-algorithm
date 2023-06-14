package array;

/**
 * @Author lihongxing
 * @Date 2023/6/14 17:07
 */
public class _27 {
    // 双指针法实现原地修改
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for(;fast < nums.length;fast ++){
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            if(nums[slow] != val){
                slow++;
            }
        }
        return slow;
    }
}
