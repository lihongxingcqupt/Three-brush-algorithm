package avarice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/8/6 14:05
 */
public class _524 {
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aa");
        list.add("a");
        System.out.println(findLongestWord("aaa",list));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() != o1.length() ? o2.length() - o1.length() : String.CASE_INSENSITIVE_ORDER.compare(o1,o2);
            }
        });
        for(int i = 0;i < dictionary.size();i++){
            if(hasSeq(s,dictionary.get(i))){
                return dictionary.get(i);
            }
        }
        return "";
    }

    private boolean hasSeq(String s, String temp) {
        int index = 0;
        for(int i = 0;i < s.length();i++){
            if(index == temp.length())return true;
            if(s.charAt(i) != temp.charAt(index))continue;
            index ++;
        }
        if(index == temp.length())return true;
        return false;
    }
}
