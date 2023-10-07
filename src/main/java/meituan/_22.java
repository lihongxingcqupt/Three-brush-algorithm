package meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/23 14:02
 */
public class _22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        int count = countSimilarPairs(strings);
        System.out.println(count);
    }

    public static int countSimilarPairs(String[] strings) {
        int count = 0;
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String str : strings) {
            // 将字符串转换为字符数组并排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            // 使用排序后的字符数组作为键，统计相似字符串的个数
            String sortedStr = new String(chars);
            frequencyMap.put(sortedStr, frequencyMap.getOrDefault(sortedStr, 0) + 1);
        }

        // 对于每个相似字符串组，计算其组合数
        for (int freq : frequencyMap.values()) {
            count += freq * (freq - 1) / 2;
        }

        return count;
    }
}
