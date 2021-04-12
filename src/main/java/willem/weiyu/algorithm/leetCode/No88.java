package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

/**
 * @Author willem
 * @Description 给你两个有序整数数组nums1和nums2，合并到nums1及nums2，使之成为一个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array
 * @Date 2021/2/25 22:29
 */
public class No88 {

    /**
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(m+n),m为num1的长度，n为num2的长度
     * @param num1
     * @param num2
     * @return
     */
    public static int[] solution(int[] num1,int[] num2){
        if ((num1 == null || num1.length < 1) && (num2 == null || num2.length < 1)) {
            return null;
        }
        if (num1 == null || num1.length < 1){
            return num2;
        }
        if (num2 == null || num2.length < 1){
            return num1;
        }
        int i=0;
        int j=0;
        int k=0;
        int[] result = new int[num1.length + num2.length];
        while (i < num1.length && j < num2.length){
            if (num1[i] < num2[j]){
                result[k++] = num1[i];
                i++;
            } else if (num1[i] > num2[j]){
                result[k++] = num2[j];
                j++;
            } else {
                result[k++] = num1[i];
                result[k++] = num2[j];
                i++;
                j++;
            }
        }
        if (i == num1.length){
            for (int l = j; l < num2.length; l++) {
                result[k++] = num2[l];
            }
        }
        if (j == num2.length){
            for (int l = i; l < num1.length; l++) {
                result[k++] = num1[l];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,5};
        int[] num2 = new int[]{2,7,8,9};
        Utils.printArr(solution(num1,num2));
    }
}
