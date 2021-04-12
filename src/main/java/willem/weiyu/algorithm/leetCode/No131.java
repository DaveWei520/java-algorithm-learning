package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/03/07 22:51
 * @description: 给你一个字符串 s，请你将s分割成一些子串，使每个子串都是回文串 。返回s所有可能的分割方案
 * https://leetcode-cn.com/problems/palindrome-partitioning
 */
public class No131 {

    public static List<String> solution(String str){
       if (str == null || str.isEmpty()){
           return Collections.emptyList();
       }
        List<String> result = new ArrayList<>();
       result.add(str.charAt(0)+"");
       result.add(str.charAt(str.length()-1)+"");
        for (int i = 1; i < str.length() - 1; i++) {
            result.add(str.charAt(i)+"");
            append(result, str, i, i-1, i+1);
        }
        return result;
    }

    private static void append(List<String> list, String str, int index, int start, int end){
        if (start ==0 && end==str.length()-1){
            if (str.charAt(index) == str.charAt(start)) {
                list.add(str.substring(start,index+1));
            }
            if (str.charAt(index) == str.charAt(end)) {
                list.add(str.substring(index));
            }
            if (str.charAt(start) == str.charAt(end)){
                list.add(str);
            }
            return;
        }
        if (str.charAt(index) == str.charAt(start)) {
            list.add(str.substring(start,index+1));
            append(list, str, index, start-1,end);
        }
        if (str.charAt(index) == str.charAt(end)) {
            list.add(str.substring(index,end+1));
            append(list, str, index, start, end+1);
        }
        if (str.charAt(start) == str.charAt(end)){
            list.add(str.substring(start, end+1));
            append(list, str, index, start-1, end+1);
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        String str2 = "a";
        Utils.printList(solution(str));
        Utils.printList(solution(str2));
    }
}
