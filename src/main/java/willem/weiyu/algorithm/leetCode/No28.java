package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/03/05 14:30
 * @description: 给定一个haystack字符串和一个needle字符串，在haystack字符串中找出needle字符串出现的第一个位置(从0开始)。如果不存在，则返回-1
 * https://leetcode-cn.com/problems/implement-strstr
 */
public class No28 {

    /**
     * 时间复杂度：O((n-l)l)，n为haystack的长度，l为needle的长度
     * 空间复杂度：O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public static int solution(String haystack, String needle){
        if (haystack == null || needle == null || (haystack.isEmpty() && needle.isEmpty()) || haystack.length() < needle.length()) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            int cur = i;
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(cur) != needle.charAt(j)) {
                    break;
                }
                cur++;
                j++;
            }
            if (j == needle.length()){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println(solution(haystack, needle));
        System.out.println(solution(haystack2, needle2));
    }
}
