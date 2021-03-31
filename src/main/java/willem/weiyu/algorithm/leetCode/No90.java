package willem.weiyu.algorithm.leetCode;

import java.util.Collections;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/03/31 20:43
 * @description: 给你一个整数数组nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）
 */
public class No90 {

    public static List<List<Integer>> solution(int[] nums){
        if (nums == null || nums.length < 1){
            return Collections.EMPTY_LIST;
        }
        //TODO
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        solution(nums);
    }
}
