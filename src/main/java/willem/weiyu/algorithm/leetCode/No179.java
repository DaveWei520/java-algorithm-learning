package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

/**
 * @Author willem
 * @Description 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数
 * https://leetcode-cn.com/problems/largest-number/
 * @Date 2021/4/12 15:02
 */
public class No179 {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static String solution(int[] nums){
        if (nums == null || nums.length < 1){
            return null;
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                compare(nums, i, j);
            }
            strBuilder.append(nums[i]);
        }
        strBuilder.append(nums[nums.length - 1]);
        return strBuilder.toString();
    }

    private static void compare(int[] nums, int bigger, int cur){
        String biggerStr = nums[bigger] + "";
        String curStr = nums[cur] + "";
        int loop = biggerStr.length() < curStr.length()? biggerStr.length() + 1 : curStr.length() + 1;
        char temp = '0';
        for (int i = 0; i < loop; i++) {
            if (i < biggerStr.length() && i < curStr.length()) {
                char preCh = biggerStr.charAt(i);
                char curCh = curStr.charAt(i);
                if (preCh - curCh > 0) {
                    break;
                } else if (preCh - curCh < 0) {
                    Utils.swapInt(nums, bigger, cur);
                    break;
                } else {
                    temp = preCh;
                }
            } else {
                if (i == biggerStr.length()) {
                    char curCh = curStr.charAt(i);
                    if (temp - curCh > 0) {
                        break;
                    } else if (temp - curCh < 0){
                        Utils.swapInt(nums, bigger, cur);
                        break;
                    } else {
                        continue;
                    }
                } else if (i == curStr.length()) {
                    char preCh = biggerStr.charAt(i);
                    if (temp - preCh > 0) {
                        Utils.swapInt(nums, bigger, cur);
                        break;
                    } else if (temp - preCh < 0){
                        break;
                    } else {
                        continue;
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34323,3432};
        System.out.println(solution(nums));
    }
}
