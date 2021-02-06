package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 基本思想；通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 *
 * 时间复杂度O(nlogn)
 * 空间复杂度O(logn)
 */
public class QuickSort {

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
