package com.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 基本思想：从未排好的部分的第一个作为最小（最大）的，然后依次和剩余的比较，如果有更小（更大）的，
 * 记下下标，以此作为新的最小（最大）值，继续比较，一趟结束后，可以得到最小值
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 */
public class SelectSortDemo {

    public static void selectSort(int[] array) {
        if (array.length < 1)
            return;
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int value = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < value) {
                    value = array[j];
                    pos = j;
                }
            }
            array[pos] = array[i];
            array[i] = value;
        }
        System.out.println("排序后===" + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        selectSort(array);
    }
}
