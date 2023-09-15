package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/10 20:44
 */
public class _tx4 {
    static final int chushuchu = (int)1e9 + 7;
    public static void main(String[] args) {
        Scanner sccccccaa = new Scanner(System.in);
        int t = sccccccaa.nextInt();
        for(int i = 0;i < t;i++){
            long nn = sccccccaa.nextLong();
            long mm = sccccccaa.nextLong();
            long ans = fangfa1(2,nn - mm,chushuchu);
            ans = (ans - 1 + chushuchu) % chushuchu;
            System.out.println(ans);
        }
    }

    private static long fangfa1(long shuzi1, long shuzi2, long chushuchu) {
        long ans = 1;
        while(shuzi2 > 0){
            if((shuzi2 & 1) == 1){
                ans = ans * shuzi1 % chushuchu;
            }
            shuzi1 = shuzi1 * shuzi1 % chushuchu;
            shuzi2 >>= 1;
        }
        return ans;
    }
}
