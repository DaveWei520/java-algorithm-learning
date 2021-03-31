package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/03/21 16:12
 * @description: 给定一个m*n的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0。请使用原地算法
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class No73 {

    public static void solution(int[][] matrix){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix[i].length; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution(matrix);
        Print.printMultiArr(matrix);
    }
}
