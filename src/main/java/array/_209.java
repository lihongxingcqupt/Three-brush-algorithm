package array;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/6/14 17:24
 */
public class _209 {
    @Test
    public void test(){
        int i = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
    public int minSubArrayLen(int target, int[] nums) {
        boolean flag = false;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(sum >= target){
                flag = true;
                while (sum >= target){
                    sum -= nums[left];
                    left++;
                }
                minLen = Math.min(minLen,i - left + 2);
            }
        }
        return flag ? minLen : 0;
    }
}
