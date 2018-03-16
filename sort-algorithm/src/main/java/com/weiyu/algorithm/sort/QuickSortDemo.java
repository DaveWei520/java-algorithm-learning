package com.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSortDemo {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println("快速排序后===" + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            //选基准值
            int baseNum = array[start];
            //记录中间值
            int midNum;
            int i = start;
            int j = end;
            do {
                while ((array[i] < baseNum) && j > start) {
                    i++;
                }
                while (((array[j] > baseNum) && j > start)) {
                    j--;
                }
                if (i <= j) {
                    midNum = array[i];
                    array[i] = array[j];
                    array[j] = midNum;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                quickSort(array, start, j);
            }
            if (end > i) {
                quickSort(array, i, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        quickSort(array);
    }
}
