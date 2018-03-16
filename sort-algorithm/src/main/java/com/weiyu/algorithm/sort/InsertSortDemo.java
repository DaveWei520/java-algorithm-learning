package com.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
 * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
 * 如此反复循环，直到全部排好顺序
 */
public class InsertSortDemo {

    public static void insertSort(int[] array) {
        if (array.length < 1)
            return;
        int insertNum;
        for (int i = 1; i < array.length; i++) {
            insertNum = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > insertNum) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNum;
        }
        System.out.println("排序后===" + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        insertSort(array);
    }
}
