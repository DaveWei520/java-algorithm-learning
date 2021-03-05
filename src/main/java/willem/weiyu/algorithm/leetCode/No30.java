package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/03/05 15:22
 * @description: 给定一个字符串s和一些长度相同的单词words。找出s中恰好可以由words中所有单词串联形成的子串的起始位置。注意子串要与words中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 */
public class No30 {

    public static int[] solution(String s, String[] words){
        return null;
    }


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = new String[]{"word","good","best","word"};

        Print.printArr(solution(s, words));
        Print.printArr(solution(s2, words2));
    }
}
