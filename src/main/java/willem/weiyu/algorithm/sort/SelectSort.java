package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
 *
 */
public class SelectSort {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array.length < 1){
            return;
        }
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
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        System.out.println("排序前=>" + Arrays.toString(array));
        selectSort(array);
        System.out.println("排序后=>" + Arrays.toString(array));
    }
}
