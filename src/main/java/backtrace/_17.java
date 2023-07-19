package backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lihongxing
 * @Date 2023/7/18 21:36
 */
public class _17 {
    List<String> res = new ArrayList<>();
    Map<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)return new ArrayList<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        dfs(new StringBuilder(),digits,0);
        return res;
    }
    public void dfs(StringBuilder sb,String digits,int index){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int i = 0;i < map.get(digits.charAt(index) - '0').length();i++){
            sb.append(map.get(digits.charAt(index) - '0').charAt(i));
            dfs(sb,digits,index + 1);
            sb.delete(sb.length() - 1,sb.length());
        }
    }
}
