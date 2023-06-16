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









//    实现parseInt函数，如果超过了整形表示的范围，则返回错误
//    func parseInt(str string) (int res, err error);
//    测试对应的用例和边界情况

    @Test
    public void test1(){
        long maxInt = Integer.MIN_VALUE;
//        int res = parseInt(Integer.MAX_VALUE + "");
        long input1 = maxInt - 1;
        System.out.println(input1);
        // 最小值

        int res = parseInt( input1+ "");
//        int res = parseInt("50");
//        int res = parseInt("500");

        System.out.println(res);
    }
    int parseInt(String string){
        long maxFu = Integer.MAX_VALUE;
        long yuzhi = maxFu + 1;
        boolean flag = false;
        if(string.charAt(0) == '-'){
            string = string.substring(1);
            flag = true;
        }

        int len = string.length();
        long res = 0;
        for(int i = 0;i < len;i++){
            try {
                // 计算res
                res += (string.charAt(i) - '0') * Math.pow(10,len - i - 1);
            }catch (Exception e){
                throw new RuntimeException("error");
            }
            if(!flag && res > Integer.MAX_VALUE){
                throw new RuntimeException("error");
            }
            if(flag && res > yuzhi){
                throw new RuntimeException("error");
            }
        }
        if(flag){
            return (int) -res;
        }
        return (int) res;
//        return flag ? int(-res) : int(-res);
    }








}
