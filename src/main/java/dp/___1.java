package dp;

import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/11/13 14:17
 */
public class ___1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            float totalMoney = sc.nextFloat(); // 替换为你实际的总金额
            int bottles = calculateBottles(totalMoney);
            System.out.println("总共可以买到 " + bottles + " 瓶饮料。");
        }
        // 递归方法，计算总共可以买到多少瓶饮料
        private static int calculateBottles(float money) {
            if (money < 5.0f) {
                // TODO 递归出口，直到它小于5，
                return 0; // 如果剩余金额不足以买一瓶饮料，则返回0
            } else {
                //TODO 要卖钱啊，少了
                int currentBottles = (int) (money / 5.0f); // 计算当前可以买到的瓶数
                //括号少了，先%5还要加卖到的钱，TODO 没有，多余了，里面没有trace，括号少了半个，错了啊，后半段，在里面
                int remainingBottles = calculateBottles((money % 5.0f) + (currentBottles * 0.5f)); // 递归计算剩余金额可以买到的瓶数
                return currentBottles + remainingBottles;
            }
        }
}

