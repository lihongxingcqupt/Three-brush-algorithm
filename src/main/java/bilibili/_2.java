package bilibili;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/29 19:33
 */
public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
        }
        int ans = 0;
        int l = a[0];
        int r = a[1];
        int i = 2;
        while(i < n){
            int min = Math.min(l,r);
            ans += min;
            l -= min;
            r -= min;
            if(l < 0){
                r = a[i ++];
            }else if(r > 0){
                l = a[i++];
            }else if(l == r){
                if(i < n){
                    r = a[i];
                    i++;
                }
                if(i < n){
                    l = a[i];
                    i++;
                }
            }
        }
        int tmp = Math.max(l,r);
        ans += tmp;
        System.out.println(ans);
    }
}
