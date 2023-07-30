package avarice;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/7/30 17:40
 */
public class _135 {
    @Test
    public void test(){
        candy(new int[]{1,3,4,5,2});
    }
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for(int i = 0;i < candy.length;i++){
            if(i == 0){
                candy[i] = 1;
                continue;
            }
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }
        for(int i = candy.length - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1]){
               candy[i] = Math.max(candy[i],candy[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }
}
