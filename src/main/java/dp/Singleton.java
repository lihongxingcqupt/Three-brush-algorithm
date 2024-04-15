package dp;

/**
 * @Author lihongxing
 * @Date 2023/11/27 11:33
 */
public class Singleton {
    // 单例对象
    private volatile static Singleton uniqueInstance;

    // 私有化构造方法，不让new
    private Singleton(){

    }
    // 获取单例的方法
    public static Singleton getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
