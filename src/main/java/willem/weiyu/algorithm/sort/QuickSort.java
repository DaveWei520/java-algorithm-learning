package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 * 时间复杂度O(nlogn)
 * 空间复杂度O(logn)
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println("快速排序后===" + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        //选基准值
        int baseNum = array[start];
        //记录中间值
        int midNum;
        int i = start;
        int j = end;
        while (i < j) {
            //先看右边，依次往左递减
            while (baseNum <= array[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (baseNum >= array[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                midNum = array[j];
                array[j] = array[i];
                array[i] = midNum;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        array[start] = array[i];
        array[i] = baseNum;
        //递归调用左半数组
        quickSort(array, start, j - 1);
        //递归调用右半数组
        quickSort(array, j + 1, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        quickSort(array);
    }
}
