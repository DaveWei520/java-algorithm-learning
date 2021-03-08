package willem.weiyu.algorithm.leetCode;

import java.util.Arrays;

/**
 * @Author willem
 * @Description 给你一个字符串s，请你将s分割成一些子串，使每个子串都是回文，返回符合要求的 最少分割次数
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * @Date 2021/3/8 22:25
 */
public class No132 {

    //TODO
    public static int solution(String str){
        if (str == null || str.isEmpty()){
            return -1;
        }
        int len = str.length();
        int[] num = new int[len+1];
        Arrays.fill(num,Integer.MAX_VALUE);
        num[0] = 0;
        num[1] = 0;
        for (int i = 2; i <= len; i++) {
            if (str.charAt(0) == str.charAt(i-1)){
                num[i] = num[i-1];
            } else {
                num[i] = num[i-1]+1;
            }
        }
        return num[len];
    }

    public static void main(String[] args) {
        String str = "aab";
        String str2 = "a";
        String str3 = "ab";
        String str4 = "efe";
        System.out.println(solution(str));
        System.out.println(solution(str2));
        System.out.println(solution(str3));
        System.out.println(solution(str4));
    }
}
