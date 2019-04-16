package acm;

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
    
}

