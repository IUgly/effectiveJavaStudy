package chapter02;

import java.math.BigDecimal;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        BigDecimal result = BigDecimal.valueOf(0);
        // n 个物品中，选择 i（i<= n-1） 个物品出来.   从剩余种类中选一个作为核心
        for (int i = 1; i < n; i++) {
            BigDecimal nJ = factBig(n);
            BigDecimal nIJ = factBig(n-i);
            BigDecimal iJ = factBig(i);
            BigDecimal up = nJ.multiply(BigDecimal.valueOf(n-i));
            BigDecimal down = nIJ.multiply(iJ);
            result = result.add(up.divide(down));
        }
        System.out.print(result.toString());
    }

    public static BigDecimal factBig(int n) {
        if (n == 1 || n == 0) {
            return BigDecimal.valueOf(1);
        } else {
            return BigDecimal.valueOf(n).multiply(factBig(n - 1));
        }
    }
}