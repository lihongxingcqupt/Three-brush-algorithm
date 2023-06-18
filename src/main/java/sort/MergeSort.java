package sort;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/6/18 10:45
 */
public class MergeSort {
    @Test
    public void test(){
        int[] nums = new int[]{5,4,2,14,6,7,2,3,5,8};
        mergeSort(new int[nums.length],nums,0,nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }
    public void mergeSort(int[] result,int[] arr,int left,int right){
        if(left >= right)return;
        int mid = left + (right - left) / 2;
        int start1 = left;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = right;
        mergeSort(result,arr,start1,end1);
        mergeSort(result,arr,start2,end2);
        int index = start1;
        while (start1 <= end1 && start2 <= end2){
            result[index ++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while(start1 <= end1){
            result[index ++] = arr[start1++];
        }
        while(start2 <= end2){
            result[index++] = arr[start2++];
        }
        for(int i = left;i <= right;i++){
            arr[i] = result[i];
        }
    }
}
