package tx;

/**
 * @Author lihongxing
 * @Date 2023/9/4 17:57
 */
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param arr int整型一维数组
         * @return int整型
         */
        public int perfectPair (int[] arr) {
            // write code here

            int res = 0;
            // int[] dp = new int[arr.length + 1];
            // dp[0] = 0;
            for(int i = 0; i < arr.length; i++) {
                for(int j = i+1; j < arr.length; j++) {
                    long temp = (long)arr[i] * (long)arr[j];
                    if(jianyan(temp)) {
                        res++;
                    }
                }
            }


            return res;
        }

        public static boolean jianyan(long count) {

            if(count <= 10) {
                return true;
            }
            while(count > 10) {
                long t = count % 10;
                if(t != 0) {
                    return false;
                }
                count /= 10;
            }

            return true;
        }
    }

