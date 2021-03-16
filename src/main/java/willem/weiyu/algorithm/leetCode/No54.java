package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Print;

/**
 * @Author willem
 * @Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 * https://leetcode-cn.com/problems/spiral-matrix
 * @Date 2021/3/15 22:25
 */
public class No54 {

    public static int[] solution(int[][] matrix){
        if (matrix == null || matrix.length < 1|| matrix[0] == null || matrix[0].length < 1){
            return null;
        }
        int[] result = new int[matrix.length* matrix[0].length];
        int rowStep = matrix.length - 1;
        int colStep = matrix[0].length;
        int row = 0;
        int col = 0;
        int index = 0;
        boolean rowReverse = false;
        boolean colReverse = false;
        boolean isFirst = true;
        int tempStep;
        while (rowStep !=0 || colStep !=0) {
            tempStep = 0;
            if (colReverse == false &&  tempStep < colStep){
                if(!isFirst){
                    col++;
                }
                while (tempStep < colStep) {
                    if (index == result.length){
                        break;
                    }
                    result[index++] = matrix[row][col++];
                    tempStep++;
                }
                colReverse = true;
                colStep--;
                col--;
            }

            tempStep = 0;
            if (rowReverse == false && tempStep < rowStep) {
                row++;
                while (tempStep < rowStep) {
                    if (index == result.length){
                        break;
                    }
                    result[index++] = matrix[row++][col];
                    tempStep++;
                }
                rowReverse = true;
                rowStep--;
                row--;
            }

            tempStep = 0;
            if (colReverse && tempStep < colStep){
                col--;
                while (tempStep < colStep) {
                    if (index == result.length){
                        break;
                    }
                    result[index++] = matrix[row][col--];
                    tempStep++;
                }
                colReverse = false;
                colStep--;
                col++;
            }

            tempStep = 0;
            if (rowReverse && tempStep <rowStep){
                row--;
                while (tempStep < rowStep){
                    if (index == result.length){
                        break;
                    }
                    result[index++] = matrix[row--][col];
                    tempStep++;
                }
                rowReverse = true;
                rowStep--;
                row++;
            }
            isFirst = false;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Print.printArr(solution(matrix));
    }
}
