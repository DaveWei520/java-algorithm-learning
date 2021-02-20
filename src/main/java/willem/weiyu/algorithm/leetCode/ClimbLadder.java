package willem.weiyu.algorithm.leetCode;

import java.util.Arrays;

/**
 * @author: willem
 * @create: 2021/01/26 16:23
 * @description: 假设一个楼梯有 N 阶台阶，人每次最多可以跨 M 阶，求总共的爬楼梯方案数
 */
public class ClimbLadder {

    /**
     * 可以转化为f(n) = f(n-1) + f(n-2)
     * @param ladder
     * @param maxJump
     * @return
     */
    public static int solution(int ladder, int maxJump){
        int jump = 0;
        if (ladder == 0) {
            return 1;
        }
        if (ladder >= maxJump) {
            // 剩下的楼梯大于最大可跳跃数
            for (int i = 1; i <= maxJump; i++) {
                jump += solution(ladder - i, maxJump);
            }
        } else {
            // 剩下的楼梯不足最大可跳跃数
            jump = solution(ladder, ladder);
        }
        return jump;
    }

    /**
     * 动态规划求解
     * @param ladder
     * @return
     */
    public static int solution2(int ladder){
        if (ladder <= 2){
            return ladder;
        }
        int[] dp = new int[ladder+1];
        Arrays.fill(dp, 0);
        dp[1] = dp[2] = 2;
        for (int i = 3; i <= ladder; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[ladder];
    }

    public static void main(String[] args) {
        System.out.println(solution(20, 2));
        System.out.println(solution2(20));
    }
}
