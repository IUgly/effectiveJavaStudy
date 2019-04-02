package chapter02;

/**
 * @author kuangjunlin
 */

public enum SingletonEnum {
    /**
     * Singleton实例
     */
    INSTACNE;
    private SingletonByEnum singletonByEnum;

    SingletonEnum() {
        this.singletonByEnum = new SingletonByEnum();
    }

    public SingletonByEnum getInstance(){
        return this.singletonByEnum;
    }
}
