package dp;

import java.util.Stack;

/**
 * @Author lihongxing
 * @Date 2023/8/27 15:15
 */
public class _739 { _739(){

    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++){
            if(stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    int temp = stack.pop();
                    res[temp] = i - temp;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
