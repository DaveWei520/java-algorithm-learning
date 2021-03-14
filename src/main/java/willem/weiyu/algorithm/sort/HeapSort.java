package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
 * 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
 */
public class HeapSort {

    /**
     *  时间复杂度：O(nlogn)，n为数组的长度
     *  空间复杂度：O(1)
     * @param array
     */
    public static void headSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            //建堆
            buildMaxHeap(array, length - i - 1);
            //交换堆顶和最后一个元素
            swap(array, 0, length - i - 1);
        }
    }

    private static void buildMaxHeap(int[] array, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = lastIndex / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (2 * k <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k;
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
        array[first] = array[first] ^ array[last];
        array[last] = array[first] ^ array[last];
        array[first] = array[first] ^ array[last];
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        System.out.println("堆排序前=>" + Arrays.toString(array));
        headSort(array);
        System.out.println("堆排序后=>" + Arrays.toString(array));
    }
}
