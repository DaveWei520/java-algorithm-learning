package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * @Date 2021/3/2 23:43
 */
public class No304 {

    /**
     * 时间复杂度：O(mn),m为行数，n为列数
     * 空间复杂度：O(1)
     * @param matrix
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public static int solution(int[][] matrix,int row1, int col1, int row2, int col2){
        if (matrix == null || matrix.length < 1) {
            return Integer.MIN_VALUE;
        }
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <=col2 ; j++) {
                result += matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        System.out.println(solution(matrix,2,1,4,3));
    }
}
