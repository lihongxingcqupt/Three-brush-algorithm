package array;

/**
 * @Author lihongxing
 * @Date 2023/6/14 17:13
 */
public class _977 {
    public int[] sortedSquares(int[] nums) {
        int right = 0;
        int left = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if(num > 0){
                break;
            }
            right ++;
        }
        int index = 0;
        left = right - 1;
        while(left >= 0 && right < nums.length){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                res[index ++] = nums[right] * nums[right];
                right++;
            }else{
                res[index ++] = nums[left] * nums[left];
                left --;
            }
        }
        while(left >= 0){
            res[index ++] = nums[left] * nums[left];
            left --;
        }
        while(right < nums.length){
            res[index ++] = nums[right] * nums[right];
            right++;
        }
        return res;
    }
}
