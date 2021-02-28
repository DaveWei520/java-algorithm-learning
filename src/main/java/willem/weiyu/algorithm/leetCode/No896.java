package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/28 13:33
 * @description: 如果数组是单调递增或单调递减的，那么它是单调的.当给定的数组是单调数组时返回true，否则返回false
 * https://leetcode-cn.com/problems/monotonic-array
 */
public class No896 {

    /**
     * 时间复杂度：O(n)，n为数组的长度
     * 空间复杂度：O(1)
     * @param arr
     * @return
     */
    public static boolean solution(int[] arr){
        if (arr == null || arr.length < 1){
            return false;
        }
        boolean flag = true;
        boolean asc = arr[0] < arr[1] ? true : false;
        for (int i = 1; i < arr.length - 1; i++) {
            if (!flag){
                return false;
            }
            if (asc){
                flag = flag && arr[i-1] < arr[i] && arr[i] < arr[i+1];
            } else {
                flag = flag && arr[i-1] > arr[i] && arr[i] > arr[i+1];
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,8,9};
        System.out.println(solution(arr1));
        int[] arr2 = new int[]{12,9,6,3,2,1};
        System.out.println(solution(arr2));
        int[] arr3 = new int[]{1,3,7,4,5};
        System.out.println(solution(arr3));
    }
}
