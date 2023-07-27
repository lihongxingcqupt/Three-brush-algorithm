package backtrace;

public class _376 {
    public int wiggleMaxLength(int[] nums) {
        int[][] sum = new int[2][nums.length];
        int maxZheng = 1;
        int maxFu = 1;
        sum[0][0] = 1;
        sum[1][0] = 1;
        for(int i = 1;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    maxZheng = Math.max(sum[0][j] + 1,maxZheng);
                }else if(nums[i] < nums[j]){
                    maxFu = Math.max(maxFu,sum[1][j] + 1);
                }
            }
            sum[0][i] = maxFu;
            sum[1][i] = maxZheng;
            maxFu = 0;
            maxZheng = 0;
        }
        return Math.max(Math.max(sum[0][nums.length - 1],sum[1][nums.length - 1]),1);
    }
}
