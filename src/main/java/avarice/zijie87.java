package avarice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/8/7 19:37
 */
public class zijie87 {
    boolean[] isUsed;
    List<List<Integer>> res = new ArrayList<>();
    @Test
    public void test(){
        isUsed = new boolean[5];
        dfs(4,new ArrayList<>());

        for (List<Integer> list : res) {
            for (Integer cur : list) {
                System.out.print(cur + "  ");
            }
            System.out.println();
        }
    }
    public void dfs(int len, List<Integer> list){
        if(list.size() == len){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1;i <= len;i++){
            if(!isUsed[i]){
                list.add(i);
                isUsed[i] = true;
                dfs(len,list);
                isUsed[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
