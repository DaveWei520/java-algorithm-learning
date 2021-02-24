package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Print;

/**
 * @Author willem
 * @Description 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]
 * https://leetcode-cn.com/problems/flipping-an-image
 * @Date 2021/2/24 22:20
 */
public class No832 {

    /**
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     * @param arr
     */
    public static void solution(int[][] arr){
        if (arr == null || arr.length < 1){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = arr[i].length - 1;
            while (start < end){
                arr[i][start] = arr[i][start]^arr[i][end];
                arr[i][end] = arr[i][start]^arr[i][end];
                arr[i][start] = arr[i][start]^arr[i][end];
                start++;
                end--;
            }
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[i][j] == 0? 1:0;
            }
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param A
     * @return
     */
    public int[][] solution2(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println("反转前======");
        Print.printMultiArr(arr);
        System.out.println("反转后======");
        solution(arr);
        Print.printMultiArr(arr);
    }
}
