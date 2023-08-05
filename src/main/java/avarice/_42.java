package avarice;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author lihongxing
 * @Date 2023/8/5 16:24
 */
public class _42 {
    @Test
    public void test(){
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
    public int trap(int[] height) {

        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i < height.length;i++){
            if(deque.isEmpty() || height[deque.peekFirst()] >= height[i]){
                deque.addFirst(i);
            }else{
                while(height[i] > height[deque.peekFirst()]){
                    int mid = deque.pollFirst();
                    if(deque.isEmpty())break;
                    int width = i - deque.peekFirst() - 1;
                    int min_hei = Math.min(height[i],height[deque.peekFirst()]);
                    res += width * (min_hei - height[mid]);
                }
                deque.addFirst(i);
            }
        }
        return res;
    }
}
