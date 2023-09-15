package meituan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/9/10 10:56
 */
public class test {
    List<List<Integer>> res = new ArrayList<>();
    @Test
    public void test(){
        getZuhe(8,2,1,0,new ArrayList<>());
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    private void getZuhe(int n, int k,int index, int sum, List<Integer> list) {
        if(sum == n && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size() >= k)return;
        for(int i = index;i <= n;i++){
            list.add(i);
            sum += i;
            getZuhe(n,k,i,sum,list);
            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}
