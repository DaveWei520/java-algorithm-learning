package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/23 12:04
 * @description: 给你两个单词word1和word2，请你计算出将word1转换成word2 所使用的最少操作数。你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class No72 {

    /**
     * 时间复杂度：O(mn)，m为from的长度，n为to的长度
     * 空间复杂度：O(mn)，m为from的长度，n为to的长度
     * @param from
     * @param to
     * @return
     */
    public static int solution(String from,String to){
        int m = from.length();
        int n = to.length();
        if (m * n == 0){
            return m + n;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (from.charAt(i-1) == to.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String from = "rad";
        String to = "apple";
        System.out.println(solution(from, to));
    }
}
