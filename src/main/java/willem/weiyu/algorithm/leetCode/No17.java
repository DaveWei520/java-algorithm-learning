package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author willem
 * @Description 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * @Date 2021/2/18 22:35
 */
public class No17 {

    /**
     * 时间复杂度：O(3^m×4^n)，其中m是输入中对应3个字母的数字个数（包括数字2、3、4、5、6、8），是输入中对应个字母的数字个数（包括数字7、9），m+n是输入数字的总个数。当输入包含
     * m个对应3个字母的数字和n个对应4个字母的数字时，不同的字母组合一共有3^m×4^n种，需要遍历每一种字母组合。
     * 空间复杂度：O(m+n)，其中m是输入中对应3个字母的数字个数，n是输入中对应4个字母的数字个数，m+n是输入数字的总个数。除了返回值以外，空间复杂度主要取决于哈希表以及回溯过程中的递归调用层数，哈希表的大小与输入无关，可以看成常数，递归调用层数最大为m+n
     * @param num
     * @return
     */
    public static List<String> solution(String num){
        List<String> resultList = new ArrayList<>();
        if (num == null || num.length() ==0){
            return resultList;
        }
        append(resultList, new StringBuilder(), num, 0);
        return resultList;
    }

    private static void append(List<String> resultList, StringBuilder strBuilder,String num,int index){
        if (index == num.length()){
            resultList.add(strBuilder.toString());
        } else {
            String str = get(num.charAt(index));
            for (int i = 0; i < str.length(); i++) {
                strBuilder.append(str.charAt(i));
                append(resultList, strBuilder, num,index+1);
                strBuilder.deleteCharAt(index);
            }
        }
    }
    
    private static String get(char ch){
        String result = "";
        switch (ch){
            case '2':
                result = "abc";
                break;
            case '3':
                result = "def";
                break;
            case '4':
                result = "ghi";
                break;
            case '5':
                result = "jkl";
                break;
            case '6':
                result = "mno";
                break;
            case '7':
                result = "pqrs";
                break;
            case '8':
                result = "tuv";
                break;
            case '9':
                result = "wxyz";
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String num = "23";
        System.out.println(solution(num));
    }
}
