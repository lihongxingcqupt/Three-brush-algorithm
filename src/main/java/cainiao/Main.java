package cainiao;

/**
 * @Author lihongxing
 * @Date 2023/10/10 19:32
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        long zuixiai = 0;
        long zuixiaiTemp = 0;
        for (long x = r; x >= l; x--) {
            long number = x;
            long favorability = 0;

            while (number % 2 == 0) {
                number /= 2;
                favorability++;
            }

            if (favorability > zuixiai) {
                zuixiai = favorability;
                zuixiaiTemp = x;
            }
        }
        System.out.println(zuixiai);
        scanner.close();
    }
}

