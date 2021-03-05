package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/03/05 15:04
 * @description: 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。返回被除数dividend除以除数divisor得到的商。整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * https://leetcode-cn.com/problems/divide-two-integers
 */
public class No29 {

    /**
     * 时间复杂度：O(n)，n为倍数
     * 空间复杂度：O(1)
     * @param dividend
     * @param divisor
     * @return
     */
    public static int solution(int dividend, int divisor){
        if (divisor == 0){
            throw new ArithmeticException();
        }
        boolean flag;
        if(dividend > 0 && divisor > 0){
            flag = true;
        } else if (dividend < 0 && divisor < 0){
            flag = true;
        } else {
            flag = false;
        }
        int result = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend - divisor >= 0) {
            dividend -= divisor;
            result++;
        }
        if (!flag && result != 0) {
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 3));
        System.out.println(solution(7, -3));
    }
}
