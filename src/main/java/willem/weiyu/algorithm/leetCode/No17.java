package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author weiyu005@ke.com
 * @Description 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回。
 * @Date 2021/2/18 22:35
 */
public class No17 {

    public static List<String> solution(String num){
        List<String> resultList = new ArrayList<>();
        if (num == null || num.length() ==0){
            return resultList;
        }
        for (int i = 0; i < num.length(); i++) {
            num.
        }
        return resultList;
    }

    private static void append(){

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
