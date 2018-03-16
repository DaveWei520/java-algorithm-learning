package com.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 基本思想：归并排序是建立在归并操作上的一种有效的排序算法,
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。
 */
public class MergeSortDemo {

    public static void mergeSort(int[] array) {
        //在排序前，先建立一个长度等于原数组的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        System.out.println("归并排序后===" + Arrays.toString(array));
    }

    private static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            sort(array, left, mid, temp);
            //右边归并排序，使得左子序列有序
            sort(array, mid + 1, right, temp);
            //将两个有序子数组合并
            merge(array, left, mid, right, temp);
        }
    }

    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j])
                temp[t++] = array[i++];
            else
                temp[t++] = array[j++];
        }
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        //将右边剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = array[j++];
        }
        for (int k = 0; k < t; k++)
            array[left + k] = temp[k];
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        mergeSort(array);
    }
}
