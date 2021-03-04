package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组 并在使用O(1)额外空间的条件下完成。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * @Date 2021/3/4 22:11
 */
public class No26 {

    /**
     * 时间复杂度：O(n)，n为数组的长度
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        if (nums == null || nums.length < 1){
            return 0;
        }
        int len = 1;
        int index = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (val == nums[i]){
                continue;
            }
            val = nums[i];
            nums[index++] = val;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }
}
