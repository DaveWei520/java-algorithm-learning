package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author willem
 * @Description 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
 * @Date 2021/3/1 22:26
 */
public class No22 {

    /**
     * 时间复杂度：O(frac{4^n}{\sqrt{n}})在回溯过程中，每个答案需要O(n)的时间复制到答案数组中
     * 空间复杂度：O(n)，除了答案数组之外，我们所需要的空间取决于递归栈的深度，每一层递归函数需要O(1)的空间，最多递归2n层，因此空间复杂度为O(n)
     * @param n
     * @return
     */
    public static List<String> solution(int n){
        if (n < 1){
            return null;
        }
        List<String> list = new ArrayList<>();
        append(list, new StringBuilder(),0, 0, n);
        return list;
    }

    private static void append(List<String> list, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            list.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            append(list, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            append(list, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Print.printList(solution(n));
    }
}
