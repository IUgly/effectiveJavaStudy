package chapter02;

/**
 * @author kuangjunlin
 */
public class Student {
    private final String name;
    private final int student_id;
    private final double distance;
    private final int upVoteNum;
    private final String token;

    public static class Builder {
        private final String name;
        private final int student_id;

        private double distance = 0.00;
        private int upVoteNum = 0;
        private String token;

        public Builder(String name, int student_id) {
            this.name = name;
            this.student_id = student_id;
        }

        public Builder distance(double val) {
            distance = val;
            return this;
        }

        public Builder upVoteNum(int val) {
            upVoteNum = val;
            return this;
        }

        public Builder token(String val) {
            token = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public Student(Builder builder) {
        this.name = builder.name;
        this.student_id = builder.student_id;
        this.distance = builder.distance;
        this.upVoteNum = builder.upVoteNum;
        this.token = builder.token;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", student_id=" + student_id +
                ", distance=" + distance +
                ", upVoteNum=" + upVoteNum +
                ", token='" + token + '\'' +
                '}';
    }
}
