import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int input = scanner.nextInt();

        int sumInE = 0;
        int n = 0;
        for (int i = 0; i < input; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x>=-a && x<=a && y>=-b && y<=b){
                sumInE += inE(a, b, x, y) ? 1 : 0;
                n++;
            }
        }

        int upNum = sumInE * (2*a * 2*b);
        if (upNum % n == 0){
            System.out.print(upNum / n);
        }else {
            int commonNum = getCommonNum(upNum, n);
            System.out.print(upNum/commonNum + "/" + n/commonNum);
        }
        scanner.close();
    }
    public static boolean inE(int a, int b, int x, int y) {
        return ( (x*x)/(a*a) + (y*y)/(b*b) ) <= 0;
    }

    public static int getCommonNum(int upNum, int downNum){
        int start = upNum > downNum ? downNum : upNum;
        for (int i = start/2; i > 1; i--) {
            if (upNum % i == 0 && downNum % i ==0){
                return i;
            }
        }
        return 1;
    }
}
