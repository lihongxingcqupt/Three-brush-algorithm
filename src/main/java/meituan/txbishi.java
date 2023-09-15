package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author lihongxing
 * @Date 2023/9/10 21:52
 */
public class txbishi {

    public class Solution {
        // TODO 第一个
        int ans;
        List<List<Integer>> res = new ArrayList<>();
        public int pathNumber (TreeNode root) {
            ans = 0;
            dfs(root,0,0);
            return ans;
        }
        public void dfs(TreeNode curNode,int oneNum,int zeroNum){
            // 出口
            if(curNode.val == 0){
                zeroNum ++;
            }else{
                oneNum ++;
            }
            if(curNode.left == null && curNode.right == null){
                if(oneNum - zeroNum == 1){
                    ans ++;
                }
                return;
            }
            // 递归
            if(curNode.left != null){
                dfs(curNode.left,oneNum,zeroNum);
            }
            if(curNode.right != null){
                dfs(curNode.right,oneNum,zeroNum);
            }
        }

        // todo 第二个

        /**
         * @Author lihongxing
         * @Date 2023/9/10 21:02
         */
        class Main_2 {
            public void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int tizt = sc.nextInt();
                for(int i = 0;i < tizt;i++){
                    int nNum = sc.nextInt();
                    List<Integer> list_1 = new ArrayList<>();
                    Map<Integer,Integer> kVmAP = new HashMap<>();
                    int[] array_1 = new int[nNum - 1];
                    for(int j = 0;j < nNum;j++){
                        list_1.add(sc.nextInt());
                        kVmAP.put(j,list_1.get(j));
                    }
                    for(int j = 0;j < nNum - 1;j++){
                        array_1[j] = sc.nextInt();
                    }
                    func(nNum,list_1,array_1,kVmAP);
                }
            }

            private void func(int nNum, List<Integer> list_1, int[] array_1, Map<Integer, Integer> kVmAP) {
                Collections.sort(list_1);
                List<String> strings = list_1.stream().map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return String.valueOf(integer);
                    }
                }).collect(Collectors.toList());
                int len = nNum;
                if(len % 2 == 0){
                    int numnum = list_1.get(len / 2) + list_1.get(len / 2 - 1);
                    if(numnum % 2 == 0){
                        System.out.print(numnum / 2 + " ");
                    }else{
                        System.out.print((double)numnum / 2 + " ");
                    }
                }else{
                    System.out.print(list_1.get(len / 2) + " ");
                }
                for(int i = 0;i < nNum - 1;i++){
                    len --;
                    int number = kVmAP.get(array_1[i] - 1);
                    strings.remove(String.valueOf(number));
                    if(len % 2 == 0){
                        int ans = Integer.valueOf(strings.get(len / 2)) + Integer.valueOf(strings.get(len / 2 - 1));
                        if(ans % 2 == 1){
                            System.out.print((double) ans / 2 + " ");
                        }else{
                            System.out.print(ans / 2 + " ");
                        }
                    }else{
                        System.out.print(Integer.valueOf(strings.get(len / 2)) + " ");
                    }
                }
                System.out.println();
            }
        }

        //todo 第三个
        class Main {
            public void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int[] arrayK = new int[n];
                for(int i = 0;i < n;i++){
                    arrayK[i] = sc.nextInt();
                }
                Arrays.sort(arrayK);
                if(n == 1){
                    System.out.println(arrayK[0]);
                    return;
                }
                if(n == 2){
                    System.out.println(arrayK[1]);
                    return;
                }
                int lleft = 0;
                int rright = n - 2;
                int ress = arrayK[n - 1];
                while(lleft < rright){
                    ress += arrayK[rright] - arrayK[lleft];
                    rright --;
                    lleft ++;
                }
                System.out.println(ress);
            }
        }

        // todo第四个

    }
}
