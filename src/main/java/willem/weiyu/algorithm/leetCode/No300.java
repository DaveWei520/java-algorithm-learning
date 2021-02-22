package willem.weiyu.algorithm.leetCode;

import java.util.Arrays;

/**
 * @author: willem
 * @create: 2021/02/22 15:47
 * @description: No300 给你一个整数数组nums，找到其中最长严格递增子序列的长度
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class No300 {

    /**
     * dp[i]表示以nums[i]这个数字结尾的最长递增子序列的长度
     * dp[i]初始值为1，因为nums[i]结尾的最长递增子序列起码包含自己，故数组nums最长子序列长度为dp数组的最大值
     * 时间复杂度O(n^2)，n为数组长度
     * 空间复杂度O(n)，n为数组长度
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        if (nums == null || nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    //如果nums[i] > nums[j]，即最大子序列长度为dp[j]+1
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(solution(nums));
    }
}
