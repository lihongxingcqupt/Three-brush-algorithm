package array;

import org.junit.Test;

/**
 * @Author lihongxing
 * @Date 2023/11/29 14:35
 */
public class QuickSort {
    @Test
    public void test(){
        int[] nums = new int[]{10,8, 7,98, 100,75,82,7};
        quickSort(nums,0,nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void quickSort(int[] arr,int low,int high){
        if(low < high){
            int pivotIndex = partition(arr,low,high);
            quickSort(arr,low,pivotIndex - 1);
            quickSort(arr,pivotIndex + 1,high);
        }
    }
    public int partition(int[] arr,int low,int high){
        // 找到基准元素
        int pivotIndex = arr[low];
        int left = low + 1;
        int right = high;
        boolean done = false;
        while(!done){
            // 比基准小
            while (left <= right && arr[left] <= pivotIndex){
                left ++;
            }
            // 比基准大
            while(arr[right] >= pivotIndex && right >= left){
                right--;
            }
            if(right < left){
                done = true;
            }else{
                // 交换
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 将基准交换
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }
}
