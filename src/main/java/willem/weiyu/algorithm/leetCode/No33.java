package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description 整数数组nums按升序排列，数组中的值互不相同
 * 在传递给函数之前，nums在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。例如[0,1,2,4,5,6,7]在下标3处经旋转后可能变为[4,5,6,7,0,1,2]。
 * 给你旋转后的数组nums和一个整数target ，如果nums中存在这个目标值target，则返回它的下标，否则返回-1
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * @Date 2021/4/14 14:50
 */
public class No33 {

    /**
     * 时间复杂度：O(logn)，n为数组的长度
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution(nums, 0));
    }
}
