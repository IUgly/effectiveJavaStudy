package coure;

import java.util.Scanner;

/**
 * @author kuangjunlin
 */
public class Circle {
    private double radius;
    private double perimeter;
    private double ares;

    void disp(){
        System.out.println("radius=" + radius + "\n"+
                "perimeter=" + perimeter + "\n"+
                "area=" + ares
        );
    }

    Circle(){}

    public Circle(double r) {
        this.radius = r;
        this.perimeter = 2 * Math.PI * r;
        this.ares = Math.PI * Math.pow(r, 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        Circle circle = new Circle(n);
        circle.disp();
    }
}
