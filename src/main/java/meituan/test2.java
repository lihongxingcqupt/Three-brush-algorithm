package meituan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lihongxing
 * @Date 2023/9/16 19:35
 */
public class test2 {


    public static List<String> findNonConsecutiveOnesBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryStrings("", n, result);
        return result;
    }

    private static void generateBinaryStrings(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        if (current.length() == 0 || current.charAt(current.length() - 1) == '0') {
            generateBinaryStrings(current + "0", n, result);
            generateBinaryStrings(current + "1", n, result);
        } else {
            generateBinaryStrings(current + "0", n, result);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaryStrings = findNonConsecutiveOnesBinaryStrings(n);
        for (String str : binaryStrings) {
            System.out.print(str + " ");
        }
    }


}
