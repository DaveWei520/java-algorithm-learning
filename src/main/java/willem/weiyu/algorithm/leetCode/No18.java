package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/02/21 13:27
 * @description: 给定一个包含n个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和d，使得a+b+c+d的值与target相等找出所有满足条件且不重复的四元组
 * https://leetcode-cn.com/problems/4sum/
 */
public class No18 {

    /**
     * 时间复杂度：O(n^3)，其中n是数组的长度。排序的时间复杂度是O(nlogn)，枚举四元组的时间复杂度是O(n^3)，因此总时间复杂度为O(n^3+nlogn)=O(n^3)。
     * 空间复杂度：O(logn)，其中n是数组的长度。空间复杂度主要取决于排序额外使用的空间。此外排序修改了输入数组nums，实际情况中不一定允许，因此也可以看成使用了一个额外的数组存储了数组nums的副本并排序，空间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution(nums, target));
    }
}
