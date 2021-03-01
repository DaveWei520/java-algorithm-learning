package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/03/01 16:28
 * @description: 给定一个整数数组nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组nums初始化对象
 * int sumRange(int i, int j)返回数组nums从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * https://leetcode-cn.com/problems/range-sum-query-immutable
 */
public class No303 {

    /**
     * 时间复杂度：O(n)，n为nums的长度
     * 空间复杂度：O(1)
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public static int solution(int[] nums, int i, int j){
        if (nums == null || i > j || j > nums.length - 1){
            return Integer.MIN_VALUE;
        }
        int result = 0;
        for (int k = i; k <= j; k++) {
            result += nums[k];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        System.out.println(solution(nums,2,5));
    }
}
