package com.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSortDemo {

    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序后===" + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        bubbleSort(array);
    }
}
