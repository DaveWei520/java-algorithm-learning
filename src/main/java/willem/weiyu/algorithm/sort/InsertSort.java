package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止
 *
 */
public class InsertSort {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param array
     */
    public static void insertSort(int[] array) {
        if (array.length < 1){
            return;
        }
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
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        System.out.println("排序前=>" + Arrays.toString(array));
        insertSort(array);
        System.out.println("排序后=>" + Arrays.toString(array));
    }
}
