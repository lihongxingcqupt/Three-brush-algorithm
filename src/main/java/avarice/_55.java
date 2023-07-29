package avarice;

public class _55 {
    public boolean canJump(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        flag[0] = true;
        for(int i = 0;i < nums.length;i++){
            if(!flag[i])break;
            for(int j = 1;j <= nums[i];j++){
                if(i + j < nums.length){
                    flag[i + j] = true;
                }
            }
        }
        return flag[nums.length - 1];
    }
}
