package meituan;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/16 19:53
 */
public class _mt4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = findMaxM(n, arr);
        System.out.println(result);
    }

    public static int findMaxM(int n, int[] arr) {
        int maxM = 0;

        for (int bit = 31; bit >= 0; bit--) {
            int count = 0;

            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            if (count >= 2) {
                maxM = bit;
                break;
            }
        }

        return maxM;
    }
}
