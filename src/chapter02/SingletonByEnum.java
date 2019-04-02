package chapter02;


/**
 * @author kuangjunlin
 */
public class SingletonByEnum {
    int i = 0;
    public SingletonByEnum(){
        System.out.println("class被初始化" + ++i + "次");
    }

    public static void main(String[] args) {
        SingletonByEnum singleton1 = SingletonEnum.INSTACNE.getInstance();
        SingletonByEnum singleton2 = SingletonEnum.INSTACNE.getInstance();
        System.out.println("instance1 == instance2: " + (singleton1 == singleton2));
    }
}
