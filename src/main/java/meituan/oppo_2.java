package meituan;


import java.util.Scanner;

/**
 * @Author lihongxing
 * @Date 2023/9/16 21:43
 */
public class oppo_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] charArray = text.toCharArray();
        for(int i = 1;i < charArray.length;i++){
            if(i - 1 >= 0 && charArray[i] == charArray[i - 1] || i - 2 >= 0 && charArray[i] == charArray[i - 2]){
                if(charArray[i] == 'z'){
                    charArray[i] = 'a';
                }else{
                    charArray[i] = (char) ((char) charArray[i - 1] + 1);
                }
            }
        }
        System.out.println(new String(charArray));
    }
}
