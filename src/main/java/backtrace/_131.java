package backtrace;

import java.util.ArrayList;
import java.util.List;

public class _131 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0,new StringBuilder(),new ArrayList<>(),s);
        return res;
    }
    public void dfs(int index,StringBuilder sb,List<String> list,String s){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index;i < s.length();i++){
            sb.append(s.charAt(i));
            if(!isHuiwen(sb.toString()))continue;
            list.add(sb.toString());
            dfs(i + 1,new StringBuilder(),list,s);
            list.remove(list.size() - 1);
        }
    }
    public boolean isHuiwen(String s){
        int len = s.length();
        for(int i = 0;i < len;i++){
            if(s.charAt(i) != s.charAt(len - 1 - i))return false;
        }
        return true;
    }

}

