package chapter02.singleton;


/**
 * @author kuangjunlin
 */
public class SingletonByEnum {
    int i = 0;
    public SingletonByEnum(){
        System.out.println("class被初始化" + ++i + "次");
    }

    public static void main(String[] args) {
        SingletonByEnum singleton1 = SingletonEnum.INSTACNE.getSingletonByEnum();
        SingletonByEnum singleton2 = SingletonEnum.INSTACNE.getSingletonByEnum();
        System.out.println("instance1 == instance2: " + (singleton1 == singleton2));

        User user1 = new User();
        User user2 = new User();

        System.out.println("user1 == user2  :" +(user1 == user2));
    }
}
