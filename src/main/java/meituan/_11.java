package meituan;

/**
 * @Author lihongxing
 * @Date 2023/9/15 19:43
 */
public class _11 {
    public static void main(String[] args) {
        String s1 = new String("a") + new String("b");
        String s2 = new String("ab");
        String s3 = s1.intern();
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1 == s3);
    }
}
