package com.weiyu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSortDemo {

    public static void insertSort(int[] array) {
        if (array.length < 1)
            return;
        int insertNum;
        for (int i=1; i<array.length;i++){
            insertNum = array[i];
            int j = i -1;
            while (j>=0 && array[j]>insertNum){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=insertNum;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        insertSort(array);
    }
}
