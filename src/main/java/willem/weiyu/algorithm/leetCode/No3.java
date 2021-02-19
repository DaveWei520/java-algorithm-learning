package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author willem
 * @Description No3 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @Date 2021/1/19 21:31
 */
public class No3 {

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

    public static void main(String[] args) {
        System.out.println(solution1("abcabcbb"));
    }
}
