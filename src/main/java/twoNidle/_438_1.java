package twoNidle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/10/8 13:05
 */
public class _438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = p.length();
        int[] sChar = new int[26];
        int[] pChar = new int[26];
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        for(int i = 0;i < p.length();i++){
            sChar[s.charAt(i) - 'a'] ++;
            pChar[p.charAt(i) - 'a'] ++;
        }
        if(Arrays.equals(sChar,pChar)){
            res.add(0);
        }
        for(int i = p.length();i < s.length();i++){
            sChar[s.charAt(i - m) - 'a'] --;
            sChar[s.charAt(i) - 'a'] ++;
            if(Arrays.equals(sChar,pChar)){
                res.add(i - m + 1);
            }
        }
        return res;
    }
}
