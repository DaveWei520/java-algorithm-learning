package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/01/30 21:40
 * @description: No6 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列
 */
public class ConvertZ {

    public static String solution(String str, int num){
        char[] charArr = str.toCharArray();
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(num, charArr.length); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;
        for (int i = 0; i < charArr.length; i++) {
            rows.get(curRow).append(charArr[i]);
            if (curRow == 0 || curRow == num - 1) {
                goDown = !goDown;
            }
            curRow += goDown? 1 : -1;
        }
        return rows.stream().reduce((a,b) -> a.append(b)).get().toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int num = 3;
        System.out.println(solution(str, num));
    }
}
