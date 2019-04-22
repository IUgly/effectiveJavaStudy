package acm;

import java.util.Scanner;

/**
 * @author kuangjunlin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] inputNums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            inputNums[i] = scanner.nextInt();
        }

        int minNum = Integer.MAX_VALUE;
        for (int i = n-1; i >=0 ; i--) {
            minNum <  ?
        }
    }

    public static int[] funcation(int[] inputNum, int n){
        int[] result = new int[n+1];
        int minNum = Integer.MAX_VALUE;
        for (int i = n; i >= 1; i++) {
            inputNum[i] < minNum
            minNum = (inputNum[i] < minNum) ? inputNum[i] : minNum;

        }
    }

    public static int baoLi(int[] inputNum, int i, int n){
        int result = -1;
        int j = i+1;
        do {

        }
        for (int j = i + 1; j < n; j++) {
            result = (inputNum[i] < inputNum[j] && inputNum[j] < result)
                    ? inputNum[j] : result;
        }
    }
}
