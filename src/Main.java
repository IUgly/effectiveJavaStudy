import chapter02.Student;

public class Main {

    public static void main(String[] args) {
        Student kuang = new Student
                .Builder("匡俊霖", 2017211903)
                .distance(2018.11).upVoteNum(123).build();

        System.out.println(kuang.toString());
    }
}
