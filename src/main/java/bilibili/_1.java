package bilibili;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author lihongxing
 * @Date 2023/8/29 19:25
 */
public class _1 {
    public int DoubleNumber (long n) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for(int i = 1;i < 1000000;i++){
            long temp = getZhengshu(i + "" + i);
            if(temp > n)return res;
            res ++;
        }
        return res;
    }

    private long getZhengshu(String s) {
        return Long.parseLong(s);
    }
}
