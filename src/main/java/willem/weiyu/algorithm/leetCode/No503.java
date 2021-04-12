package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

/**
 * @author: willem
 * @create: 2021/03/06 15:54
 * @description: 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字x的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 * https://leetcode-cn.com/problems/next-greater-element-ii
 */
public class No503 {

    /**
     * 时间复杂度：O(n*n)，n为数组的长度
     * 空间复杂度：O(n)，n为数组的长度
     * @param nums
     * @return
     */
    public static int[] solution(int[] nums){
        if (nums == null || nums.length < 1){
            return new int[0];
        }
        int[] result = new int[nums.length];
        int index = 0;
        while (index < result.length){
            int temp = nums[index];
            boolean flag = false;
            for (int i = index; i < result.length; i++) {
                if (temp < nums[i]){
                    result[index] = nums[i];
                    flag = true;
                    break;
                }
            }
            if (!flag){
                for (int i = 0; i < index; i++) {
                    if (temp < nums[i]){
                        flag = true;
                        result[index] = nums[i];
                        break;
                    }
                }
            }
            if (!flag){
                result[index]= -1;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        Utils.printArr(solution(nums));
    }
}
