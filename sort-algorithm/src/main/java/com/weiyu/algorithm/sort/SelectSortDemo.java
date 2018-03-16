package com.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
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
