package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

/**
 * @Author willem
 * @Description 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。必须 原地 修改，只允许使用额外常数空间
 * https://leetcode-cn.com/problems/next-permutation
 * @Date 2021/4/12 17:03
 */
public class No31 {

    /**
     * 时间复杂度：O(n)
     * 空建复杂度：O(1)
     * @param nums
     */
    public static void solution(int[] nums){
        if (nums == null || nums.length < 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            Utils.swapInt(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            Utils.swapInt(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        solution(nums);
        Utils.printArr(nums);
    }
}
