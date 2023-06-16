package sort;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/6/15 19:11
 */
public class QuickSort {

    @Test
    public void test(){
        int[] nums = new int[]{7,6,5,1,4,7,5,2};
        quickSort(nums,0,nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }

    public void quickSort(int[] nums,int left,int right){
        if(nums == null || nums.length == 0)return;
        if(left >= right)return;
        int l = left;
        int r = right;
        int key = nums[left];
        while (l != r){
            while (l < r && nums[r] > key){
                r --;
            }
            while (l < r && nums[l] <= key){
                l ++;
            }
            if(l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[l];
        nums[l] = key;
        quickSort(nums,left,l - 1);
        quickSort(nums,l + 1,right);
    }

}
