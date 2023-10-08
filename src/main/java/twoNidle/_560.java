package twoNidle;

/**
 * @Author lihongxing
 * @Date 2023/10/8 14:12
 */
public class _560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == k)res ++;
            int sum = nums[i];
            for(int j = i + 1;j < nums.length;j++){
                sum += nums[j];
                if(sum == k)res++;
            }
        }
        return res;
    }
}
