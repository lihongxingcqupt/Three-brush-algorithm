package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/7/23 14:49
 */
public class _322 {
    @Test
    public void test1(){
        String[][] s = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        List<List<String>> input = new ArrayList<>();
        for(int i = 0;i < s.length;i++){
            List<String> list = new ArrayList<>();
            list.add(s[i][0]);list.add(s[i][1]);
            input.add(new ArrayList<>(list));
        }
        List<String> itinerary = findItinerary(input);

    }
    List<String> res = new ArrayList<>();
    boolean[] isUsed;
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((o1,o2)->{
            return o1.get(1).compareTo(o2.get(1));
        });
        isUsed = new boolean[tickets.size()];
        List<String> list = new ArrayList<>();
        list.add("JFK");
        dfs(tickets,"JFK",list);
        return  res;
    }
    public boolean dfs(List<List<String>> tickets,String begin,List<String> temp){
        if(temp.size() == tickets.size() + 1){
            res = new ArrayList<>(temp);
            return true;
        }
        for(int i = 0;i < tickets.size();i++){
            if(tickets.get(i).get(0).equals(begin) && !isUsed[i]){
                isUsed[i] = true;
                temp.add(tickets.get(i).get(1));
                if(dfs(tickets,tickets.get(i).get(1),temp)){
                    return true;
                }
                temp.remove(temp.size() - 1);
                isUsed[i] = false;
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println("SFO".compareTo("JFK"));
    }
}
