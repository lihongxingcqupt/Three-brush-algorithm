package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/8/13 15:17
 */
public class KEDA_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[n];
        for(int i = 0;i < n;i++){
            array1[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            array2[i] = sc.nextInt();
        }
        System.out.println(m(n,array1,array2));
    }
    public static int m(int len,int[] a,int[] b){
        ArrayList<String> strings = new ArrayList<>();
        dfs(0,len,a,strings,new StringBuilder());
        dfs(0,len,b,strings,new StringBuilder());
        return strings.size();
    }
    public static void dfs(int startIndex,int len,int[] arr,ArrayList<String> strings,StringBuilder stringBuilder){
        if(stringBuilder.length() != 0){
            String intern = new String(stringBuilder).intern();
            if(!strings.contains(intern)){
                strings.add(intern);
            }
        }
        for(int i = startIndex;i < len;i++){
            int number = arr[i];
            stringBuilder.append(number);
            dfs(i + 1,len,arr,strings,stringBuilder);
            stringBuilder = new StringBuilder();
        }
    }
}
