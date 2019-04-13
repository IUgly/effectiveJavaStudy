package chapter02.singleton;

/**
 * @author kuangjunlin
 */

public enum SingletonEnum {
    /**
     * Singleton实例
     */
    INSTACNE;
    private SingletonByEnum singletonByEnum;
    private User user;

    SingletonEnum() {
        this.singletonByEnum = new SingletonByEnum();
        this.user = new User();
    }

    public SingletonByEnum getSingletonByEnum(){
        return this.singletonByEnum;
    }

    public User getUser(){
        return this.user;
    }
}
