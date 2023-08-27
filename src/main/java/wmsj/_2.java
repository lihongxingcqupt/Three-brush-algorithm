package wmsj;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/8/26 18:36
 */
public class _2 {
    List<List<Integer>> res = new ArrayList<>();
    public int maxScore (int[] cards, int cnt) {
        dfs(cards,cnt,new ArrayList<>(),0);
        int ans = 0;
        for(int i = 0;i < res.size();i++){
            List<Integer> temp = res.get(i);
            int sum = 0;
            for (Integer integer : temp) {
                sum += integer;
            }
            if(sum % 2 == 0){
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
    public void dfs(int[] cards,int cnt,List<Integer> temp,int index){
        if(temp.size() == cnt){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index;i < cards.length;i++){
            temp.add(cards[i]);
            dfs(cards,cnt,temp,i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
