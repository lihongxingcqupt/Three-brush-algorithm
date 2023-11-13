package twoNidle;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/10/17 15:35
 */
public class _22 {
    @Test
    public void test(){
        int i = countContinuousSumArrays(6);
        System.out.println(i
        );
    }
    public int countContinuousSumArrays(int N) {
        int count = 0;
        int left = 1;
        int right = 1;
        int sum = 0;

        while (left <= N / 2) {
            if (sum < N) {
                sum += right;
                right++;
            } else if (sum > N) {
                sum -= left;
                left++;
            } else {
                count++;
                sum -= left;
                left++;
            }
        }

        return count + 1; // 加上N本身
    }


}
