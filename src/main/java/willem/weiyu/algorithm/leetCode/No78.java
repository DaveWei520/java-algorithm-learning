package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/03/31 20:53
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
 */
public class No78 {

    private static List<List<Integer>> total = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();

    /**
     * 时间复杂度：O(n*2^n)。一共2^n个状态，每种状态需要O(n)的时间来构造子集。
     * 空间复杂度：O(n)。临时数组temp的空间代价是O(n)，递归时栈空间的代价为O(n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> solution(int[] nums){
        if (nums == null || nums.length < 1){
            return Collections.EMPTY_LIST;
        }
        recursion( 0, nums);
        return total;
    }

    private static void recursion(int index, int[] nums){
        if (index == nums.length){
            total.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        recursion(index + 1, nums);
        temp.remove(temp.size() - 1);
        recursion( index + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Utils.printList(solution(nums));
    }
}
