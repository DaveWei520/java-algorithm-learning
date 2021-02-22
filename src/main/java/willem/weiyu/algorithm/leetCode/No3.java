package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author willem
 * @Description No3 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 * @Date 2021/1/19 21:31
 */
public class No3 {

    /**
     * 时间复杂度：O(n)，n为字符串的长度
     * 空间复杂度：O(n)，n为字符串的长度
     * @param str
     * @return
     */
    public static int solution1(String str){
        if (str.length() < 2) {
            return str.length();
        }
        char[] charArr = str.toCharArray();
        List<Character> list = new ArrayList<>(charArr.length);
        int length=0;
        for (int i = 0; i < charArr.length; i++) {
            char ch = charArr[i];
            list.add(ch);
            Long distinctLength = list.stream().distinct().count();
            if (list.size() == distinctLength){
                length = list.size();
            } else {
                length = list.size();
                int index = list.indexOf(ch);
                List<Character> tempList = list.subList(index +1, list.size());
                list = tempList;
            }
        }
        return length;
    }

    /**
     * 时间复杂度：O(n),n为字符串的长度
     * 空间复杂度：O(1)
     * @param str
     * @return
     */
    public static int solution2(String str){
        if (str == null){
            return 0;
        }
        if (str.length() < 2){
            return str.length();
        }
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int temp = str.indexOf(ch,start);
            if (i != temp){
                start = temp+1;
                maxLen = Math.max(maxLen, i - start+1);
                continue;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }
}
