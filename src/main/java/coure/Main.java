package coure;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kuangjunlin
 * 第一行为正整数n，表示菜的数量。n≤1000。
 * 第二行包括n个正整数，表示每种菜的价格。价格不超过50。
 * 第三行包括一个正整数m，表示卡上的余额。m≤1000。
 *
 * Output
 * 输出一行,包含一个整数，表示卡上可能的最小余额。
 * Sample Input 1
 * 1
 * 50
 * 5
 * Sample Output 1
 * -45
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String nNum = scanner.nextLine();
        String[] valStr = nNum.split(" ");
        int max = Integer.MIN_VALUE;
        int[] value = new int[valStr.length];

        for (int i = 0; i <= valStr.length-1; i++) {
            int o = Integer.valueOf(valStr[i]);
            max = (o > max) ? o : max;
            value[i] = o;
        }
        Arrays.sort(value);
        value[valStr.length - 1] = 0 ;
        int balance = Integer.valueOf(scanner.nextLine());
        int pack = ZeroOnePack(balance-5, n, value, value);
        System.out.println(balance - pack -max);
        scanner.close();
    }

    /**
     * 0-1背包问题
     * @param V 背包容量
     * @param N 物品种类
     * @param weight 物品重量
     * @param value 物品价值
     * @return dp[i]表示容量为i的背包所能装下物品的最大价值
     */
    public static int ZeroOnePack(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }

}
