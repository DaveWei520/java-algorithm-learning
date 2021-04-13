package willem.weiyu.algorithm.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author willem
 * @Description 给你一个只包含'('和')'的字符串，找出最长有效（格式正确且连续）括号子串的长度
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @Date 2021/4/13 15:12
 */
public class No32 {

    /**
     * 时间复杂度：O(n)，n为字符串长度
     * 空间复杂度：O(n)
     * @param str
     * @return
     */
    public static int solution(String str){
        if (str == null || str.length() < 1){
            return 0;
        }
        int len = 0;
        Deque<Integer> deque = new ArrayDeque<>(str.length());
        deque.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    len = Math.max(len, i - deque.peek());
                }
            }
        }
        return len;
    }

    /**
     * 时间复杂度：O(n)，n为字符串长度
     * 空间复杂度：O(n)
     * @param str
     * @return
     */
    public static int dynamicProgramming(String str){
        if (str == null || str.length() < 1){
            return 0;
        }
        int len = 0;
        int[] dp = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    dp[i] = (i >=2? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                len = Math.max(len, dp[i]);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "(()";
        System.out.println(solution(str));
        System.out.println(dynamicProgramming(str));
    }
}
