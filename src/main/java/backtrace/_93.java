package backtrace;

import java.util.ArrayList;
import java.util.List;

public class _93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(new StringBuilder(),new ArrayList<>(),s,0);
        return res;
    }
    public void dfs(StringBuilder sb,List<String> list,String s,int index){
        if(list.size() == 4 && index == s.length()){
            StringBuilder sb1 = new StringBuilder();
            res.add(sb1.append(list.get(0)).append("."+list.get(1)).append("."+list.get(2)).append("."+list.get(3)).toString());
            return;
        }
        if(list.size() >= 4 || index == s.length()){
            return;
        }
        for(int i = index;i < s.length();i++){
            sb.append(s.charAt(i));
            if(!isIp(sb.toString()))break;
            list.add(sb.toString());
            dfs(new StringBuilder(),list,s,i + 1);
            list.remove(list.size() - 1);
        }
    }
    public boolean isIp(String s){
        if (Long.parseLong(s) < 0 || Long.parseLong(s) > 255 || (s.length() != 1 && s.charAt(0) == '0'))return false;
        return true;
    }
}
