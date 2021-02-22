package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description 给你一个m*n的矩阵matrix，如果这个矩阵是托普利茨矩阵（矩阵上每一条由左上到右下的对角线上的元素都相同），返回true否则返回false。
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 * @Date 2021/2/22 22:50
 */
public class No766 {

    /**
     * 时间复杂度：O(m*n)，其中m为矩阵的行数，n为矩阵的列数
     * 空间复杂度：O(1)
     * @param matrix
     * @return
     */
    public static boolean solution(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(solution(matrix));
    }
}
