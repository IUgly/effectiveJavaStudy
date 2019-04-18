package acm.tencent;

/**
 * @author kuangjunlin
 */
public class ClimbStairs {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */

    /**
     * 法一：记忆化递归     ？？？
     * 我们可以把每一步的结果存储在 memo 数组之中，每当函数再次被调用，我们就直接从 memo 数组返回结果。
     *
     * 在 memo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 n
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 法二：  动态规划
     * 第 ii 阶可以由以下两种方法得到：
     *
     * 在第 (i-1) 阶后向上爬一阶。
     *
     * 在第 (i-2) 阶后向上爬 2 阶。
     *
     * 所以到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和。
     *
     * 令 dp[i] 表示能到达第 i 阶的方法总数：
     *
     * dp[i]=dp[i-1]+dp[i-2]
     */

    public int climbStairs2(int n){
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 法三：  斐波那契法
     * 在上述方法中，我们使用 dp 数组，其中 dp[i]=dp[i-1]+dp[i-2]。
     * dp[i] 其实就是第 i 个斐波那契数。
     *
     * Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * 现在我们必须找出以 1 和 2 作为第一项和第二项的斐波那契数列中的第 n 个数，
     * 也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     */
    public int climbStairs3(int n){
        if (n ==1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 0; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 法四： 斐波那契公式
     * 第n个斐波那契数：    1/√5{[(1+√5)/2]^n - [(1-√5)/2]^n}
     * 对于给定的问题，斐波那契序列将会被定义为
     * F0 = 1 , F1 = 1, F2 = 2,     F(N+2) = F(N) + F(N+1)
     *
     * 一般解为：F(n) = A[(1+√5)/2]^n - B[(1-√5)/2]^n
     * 由n=0时，Fn =1;
     * n=1 时，Fn = 1;
     * 解出A，B得到的值带入一般解就如下
     */
    public int climbStairs4(int n){
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + Math.sqrt(5))/2,n+1) - Math.pow((1 - Math.sqrt(5))/2,n+1);
        return (int) (fibN/sqrt5);
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs4(3));
    }
}

