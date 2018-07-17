package willem.weiyu.algorithm.backtracking;

/**
 * 八皇后问题
 * <p>
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即任意两个皇后都不能处于同一行、同一列或同一斜线上，如何求解
 */
public class Queen8 {
    // 棋盘格子的范围
    public static final int MAX_NUM = 8;
    // 二维数组作为棋盘
    int[][] chessBoard = new int[MAX_NUM][MAX_NUM];

    /**
     * 检查落点是否符合规则
     * @param x
     * @param y
     * @return
     */
    boolean check(int x, int y){
        for (int i=0; i<y; i++){
            //检查纵向
            if (chessBoard[x][i] == 1)
                return false;
            //检查左侧斜向
            if (x-1-i>=0 && chessBoard[x-1-i][y-1-i] == 1)
                return false;
            //检查右侧斜向
            if (x+1+i < MAX_NUM && chessBoard[x+1+i][y-1-i] == 1)
                return false;
        }
        return true;
    }

    public boolean settleQueen(int y){
        if (y == MAX_NUM)
            return true;
        //遍历当前行，逐一验证
        for (int i=0; i<MAX_NUM; i++){
            //为当前行清零，以免在回溯的时候出现脏数据
            for (int x=0; x<MAX_NUM; x++){
                chessBoard[x][y] = 0;
            }
            //检查是否符合规则，如符合，更改元素值并进一步递归
            if (check(i,y)){
                chessBoard[i][y] = 1;
                //递归如果返回true，说明下层已经找到解决，无需继续循环
                if (settleQueen(y+1))
                    return true;
            }
        }
        return false;
    }

    public void printChessBoard(){
        for (int i=0; i<MAX_NUM; i++){
            for (int j=0; j<MAX_NUM; j++){
                System.out.print(chessBoard[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen8 queen = new Queen8();
        queen.settleQueen(0);
        queen.printChessBoard();
    }
}
