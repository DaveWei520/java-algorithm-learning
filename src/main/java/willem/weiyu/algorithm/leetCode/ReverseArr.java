package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;

/**
 * @author: willem
 * @create: 2021/01/29 17:02
 * @description: 给定一个数组，颠倒其顺序并输出
 */
public class ReverseArr {

    /**
     * 时间复杂度：O(n/2)，为数组的长度
     * 空间复杂度：O(1)
     * @param arr
     * @param head
     * @param end
     * @return
     */
    public static int[] solution(int[] arr, int head, int end){
        if (head >= end){
            return arr;
        }
        arr[head] = arr[head] ^ arr[end];
        arr[end] = arr[head] ^ arr[end];
        arr[head] = arr[head] ^ arr[end];
        solution(arr, ++head, --end);
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        Utils.printArr(solution(arr,0,arr.length - 1));
    }
}
