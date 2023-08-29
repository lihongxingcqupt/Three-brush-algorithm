package dw;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/29 11:47
 */
public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NN = sc.nextInt();
        int MM = sc.nextInt();
        int XX = sc.nextInt();
        int temp = 0;
        if(NN == MM){
            System.out.println(1);
            temp++;
            return;
        }
        int res = 2;
        int zonghe = NN + 1;
        int llMax = XX - 1;
        int rrmax = NN - XX;
        int lll = 0;
        int rrr = 0;
        while(zonghe < MM){
            temp++;
            res ++;
            zonghe ++;
            lll ++;
            lll = Math.min(lll,llMax);
            rrr ++;
            rrr = Math.min(rrr,rrmax);
            zonghe += lll;
            zonghe += rrr;
            if(zonghe > MM){
                System.out.println(res - 1);
                return;
            }
        }
        System.out.println(res);
    }
}
