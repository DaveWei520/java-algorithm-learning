package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/01/23 16:55
 * @description: 将excel的行号与字母互转
 */
public class ExcelColNum {

    public static int col2Int(String str){
        char[] charArr = str.toCharArray();
        int result = 0;
        for (int i=0; i< charArr.length;i++) {
            result = (charArr[i] - 'A' + 1) + 26 * result;
        }
        return result;
    }

    public static String colIndex2str(int index){
        if (index <= 0) {
            return null;
        }
        String columnStr = "";
        index--;
        do {
            if (columnStr.length() > 0) {
                index--;
            }
            columnStr = ((char) (index % 26 + 'A')) + columnStr;
            index = (index - index % 26) / 26;
            } while (index > 0);
        return columnStr;
    }

    public static void main(String[] args) {
        System.out.println(col2Int("AZ"));
        System.out.println(colIndex2str(53));
    }
}
