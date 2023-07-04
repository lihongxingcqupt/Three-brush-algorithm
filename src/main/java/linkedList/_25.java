package linkedList;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;
/**
 * @Author lihongxing
 * @Date 2023/6/20 17:32
 */
public class _25 {

    @Test
    public void test2(){
//        bigIntAdd("99","99");
        bigIntAdd("778","7788");
    }
    public void bigIntAdd(String s1,String s2){
        int gap = 0;
        StringBuilder sb = new StringBuilder();
        int index1 = s1.length() - 1;
        int index2 = s2.length() - 1;
        while (index2 >= 0 && index1 >= 0){
            int s1Int = s1.charAt(index1) - '0';
            int s2Int = s2.charAt(index2) - '0';
            int cur = (s1Int + s2Int + gap) % 10;
            if(s1Int + s2Int + gap >= 10)gap = 1;
            sb.append(cur);
            index1 --;
            index2 --;
        }
        while (index1 >= 0){
            int s1Int = s1.charAt(index1) - '0';
            int cur = s1Int +  gap - 10;
            if(s1Int + gap >= 10)gap = 1;
            sb.append(cur);
            index1 --;
        }
        while (index2 >= 0){
            int s1Int = s2.charAt(index2) - '0';
            int cur = s1Int +  gap - 10;
            if(s1Int + gap >= 10)gap = 1;
            sb.append(cur);
            index2--;
        }
        if(gap > 0){
            sb.append(gap);
        }
        System.out.println(new String(sb.reverse()));
    }

}
