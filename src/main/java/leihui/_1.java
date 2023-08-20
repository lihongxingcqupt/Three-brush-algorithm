package leihui;

import java.util.*;

/**
 * @Author lihongxing
 * @Date 2023/8/20 14:34
 */
public class _1 {
    static boolean[] isUsed = new boolean[100000];
    static List<List<Character>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int c = Integer.parseInt(s1[2]);
        float d = Float.parseFloat(s1[3]);
        int sum = n * m;
        float resReal = 0.0f;
        int Anum = 0;
        int Bnum = 0;
        for(int i = 0;i <= sum;i++){
            float realSum = 0.0f;
            char[] chars = new char[sum];
            for(int j = i;j < sum;j++){
                chars[j] = 'A';
            }
            for(int j = 0;j < i;j++){
                chars[j] = 'B';
            }
            permute(chars);
            // 情况
            for (List<Character> zuhe : res) {
                realSum += getScore(zuhe,n,m,c,d);
            }
            if(realSum / res.size() > resReal){
                resReal = realSum / res.size();
                Bnum = i;
                Anum = sum - Bnum;
            }
            if(realSum / res.size() == resReal){
                if(sum - i < Anum){
                    Bnum = i;
                    Anum = sum - Bnum;
                }
            }
            res = new ArrayList<>();
        }
        System.out.print(Anum + " " + Bnum + " ");
        System.out.printf("%.1f",resReal); //输出0.646667

    }
    // 计算这种组合的分数
    private static float getScore(List<Character> zuhe,int n,int m,int c,float d) {
        float sum = 0;
        char[][] temp = new char[n][m];
        for(int i = 0;i < zuhe.size();i++){
            temp[i / m][i % m] = zuhe.get(i);
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                float temp_sum = 0.0f;
                if(temp[i][j] == 'B'){
                    // 左
                    if(j - 1 >= 0 && temp[i][j - 1] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 左上
                    if(j - 1 >= 0 && i - 1 >= 0 &&  temp[i - 1][j - 1] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 上
                    if(i - 1 >= 0 && temp[i - 1][j] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 右上
                    if(i - 1 >= 0 && j + 1 < m && temp[i - 1][j + 1] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 右
                    if(j + 1 < m && temp[i][j + 1] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 右下
                    if(j + 1 < m && i + 1 < n && temp[i + 1][j + 1] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 下
                    if(i + 1 < n && temp[i + 1][j] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    // 左下
                    if(i + 1 < n && j - 1 >= 0 && temp[i + 1][j - 1] == 'A'){
                        if(temp_sum == 0){
                            temp_sum += c * d;
                        }else{
                            temp_sum *= d;
                        }
                    }
                    sum += temp_sum;
                }

            }
        }

        return sum;
    }

    public static List<List<Character>> permute(char[] nums) {
        dfs(nums,new ArrayList<>(),new HashSet<>(),0);
        return res;
    }
    public static void dfs(char[] nums, List<Character> list, Set<Character> set,int index){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(isUsed[i] || (i > 0 && !isUsed[i - 1] && nums[i] == nums[i-1]))continue;
            isUsed[i] = true;
            list.add(nums[i]);
            dfs(nums,list,set,i + 1);
            isUsed[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
