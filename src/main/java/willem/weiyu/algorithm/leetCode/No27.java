package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description 给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。不要使用额外的数组空间，你必须仅使用O(1)额外空间并原地修改输入数组。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * https://leetcode-cn.com/problems/remove-element
 * @Date 2021/3/4 22:35
 */
public class No27 {

    /**
     * 时间复杂度：O(n)，n为数组的长度
     * 空间复杂度：O(1)
     * @param nums
     * @param val
     * @return
     */
    public static int solution(int[] nums, int val){
        if (nums == null || nums.length < 1){
            return 0;
        }
        int len = 0;
        int index = 0;
        for (int temp : nums){
            if (temp == val){
                continue;
            }
            nums[index++] = temp;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,2,3};
        int val1 = 3;
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        int val2 = 2;
        System.out.println(solution(nums1, val1));
        System.out.println(solution(nums2, val2));
    }
}
