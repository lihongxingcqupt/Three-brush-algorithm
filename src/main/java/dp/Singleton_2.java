package dp;

/**
 * @Author lihongxing
 * @Date 2023/11/27 11:38
 */
public class Singleton_2 {

    private static class SingletonHolder{
        private static final Singleton_2 instance = new Singleton_2();
    }
    private Singleton_2(){

    }
    public static Singleton_2 getInstance(){
        return SingletonHolder.instance;
    }

}
