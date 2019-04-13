package chapter02.singleton;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kuangjunlin
 */
@Data
public class User {
    private String nickname;
    private String student_id;
    private String college;
    private String name;
    private String class_id;

    private String token;
    private String total;
    private String state;

    private Deque queueInvitations = new ArrayDeque();
    private String invitingNow;

    int i = 0;
    public User() {
        System.out.println("class被初始化" + ++i + "次");
    }
}
