package willem.weiyu.algorithm.leetCode;

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

    public static int solution2(int ladder){
        if (ladder <= 2){
            return ladder;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= ladder; i++) {
            int tmp = n2;
            n2 = n1 + n2;
            n1 = tmp;
        }
        return n2;
    }

    public static void main(String[] args) {
        System.out.println(solution(20, 2));
        System.out.println(solution2(20));
    }
}
