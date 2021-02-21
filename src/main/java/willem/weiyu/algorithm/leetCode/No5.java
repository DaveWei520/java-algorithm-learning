package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description No5 给你一个字符串 s，找到 s 中最长的回文子串
 * @Date 2021/1/25 22:27
 */
public class No5 {

    /**
     * 动态规划
     * 状态：dp[i][j]表示表示字串s[i...j]是否为回文子串
     * 状态转移方程：dp[i][j]=(s[i]==s[j]) && dp[i+1][j-1]
     * 边界条件：(j-1)-(i+1)+1<2,此时(j-1)和(i+1)无法构成区间，故dp[i+1][j-1]无意义
     * 时间复杂度：O(n^2)，其中n是字符串的长度。动态规划的状态总数为O(n^2)，对于每个状态，我们需要转移的时间为O(1)
     * 空间复杂度：O(n^2)，即存储动态规划状态需要的空间
     * @param s
     * @return
     */
    public static String solution(String s){
        if (s == null || s.isEmpty()){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static String solution1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String s1 = "cbbd";
        String s2 = "a";
        String s3 = "ac";
        System.out.println(solution(s));
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
    }
}
