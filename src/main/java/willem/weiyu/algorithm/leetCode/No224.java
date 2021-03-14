package willem.weiyu.algorithm.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author willem
 * @Description 实现一个基本的计算器来计算一个简单的字符串表达式s的值
 * https://leetcode-cn.com/problems/basic-calculator
 * @Date 2021/3/10 23:15
 */
public class No224 {

    /**
     * 时间复杂度：O(n)，n为字符串的长度
     * 空间复杂度：O(n)，n为字符串的长度
     * @param str
     * @return
     */
    public static int solution(String str){
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = str.length();
        int i = 0;
        while (i < n) {
            if (str.charAt(i) == ' ') {
                i++;
            } else if (str.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (str.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (str.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (str.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + str.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String str = "1 + 1";
        String str2 = "2-1+2";
        String str3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(solution(str));
        System.out.println(solution(str2));
        System.out.println(solution(str3));
    }
}
