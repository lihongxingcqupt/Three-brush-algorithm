package avarice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lihongxing
 * @Date 2023/8/5 16:15
 */
public class _3 {
    public int lengthOfLongestSubstring(String s) {
        char[] schars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(schars[i])){
                left = Math.max(left,map.get(schars[i]) + 1);
            }
            map.put(schars[i],i);
            res = Math.max(res,i - left + 1);
        }
        return res;
    }
}
