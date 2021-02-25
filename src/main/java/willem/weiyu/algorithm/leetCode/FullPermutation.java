package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/02/20 10:24
 * @description: 给定一个字符串，输出其全排列
 */
public class FullPermutation {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param str
     */
    public static void solution(String str){
        if (str == null || str.isEmpty()){
            return;
        }
        List<String> list = new ArrayList<>();
        permutation(list, str.toCharArray(), 0);
        list.stream().forEach(val-> System.out.println(val));
    }

    private static void permutation(List<String> list,char[] chars,int index){
        if (index == chars.length -1) {
            list.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars,i,index);
            permutation(list, chars, index+1);
            swap(chars,i,index);
        }
    }

    private static void swap(char[] chars, int start,int end){
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        solution(str);
    }
}
