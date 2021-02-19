package willem.weiyu.algorithm.leetCode;

import java.util.Arrays;

/**
 * @author: willem
 * @create: 2021/02/19 15:45
 * @description: 给定不同面额的硬币coins 和一个总金额amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1
 * https://leetcode-cn.com/problems/coin-change
 */
public class No322 {

    /**
     * 时间复杂度：O(Sn)，其中S是金额，n是面额数。我们一共需要计算O(S)个状态，S为题目所给的总金额。对于每个状态，每次需要枚举n个面额来转移状态，所以一共需要O(Sn)的时间复杂度
     * 空间复杂度：O(S)。数组dp需要开长度为总金额S的空间
     * @param coins
     * @param amount
     * @return
     */
    public static int solution(int[] coins, int amount){
        if (coins == null || coins.length == 0 || amount ==0){
            return -1;
        }
        //凑成amount金额的硬币数最多只可能等于amount，所以使用amount+1就可等价于正无穷，方便后续取最小值
        int max = amount + 1;
        //数组下标为当前金额
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(solution(coins, amount));
    }
}
