package com.weiyu.algorithm.sort.demo;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSortDemo {

    public static void headSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            //建堆
            buildMaxHeap(array, length - i - 1);
            //交换堆顶和最后一个元素
            swap(array, 0, length - i - 1);
        }
        System.out.println("堆排序后===" + Arrays.toString(array));
    }

    private static void buildMaxHeap(int[] array, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (array[biggerIndex] < array[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (array[k] < array[biggerIndex]) {
                    //交换他们
                    swap(array, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] array, int first, int last) {
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        headSort(array);
    }
}
