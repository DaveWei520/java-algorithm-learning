package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author willem
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串s，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @Date 2021/2/22 23:17
 */
public class No20 {
    static Map<String, String> map = new HashMap(){{
        put("(",")");
        put("[","]");
        put("{","}");
    }};

    /**
     * 时间复杂度；O(n)
     * 空间复杂度：O()
     * @param str
     * @return
     */
    public static boolean solution(String str){
        if (str == null || str.length() < 2){
            return false;
        }
        if ((str.length() & 1) == 1){
            return false;
        }
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String ch = str.charAt(i)+"";
            if (map.containsKey(ch)){
                String key = map.get(ch);
                index.add(str.indexOf(key,i));
            } else {
                if (!index.contains(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "{}()[]";
        System.out.println(solution(str));
    }
}
