package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/03 11:54
 * @description:
 */
public class MatchSubStr {
    /**
     * KMP算法
     * @param originStr
     * @param pattern
     * @return
     */
    public static int solution(String originStr, String pattern){
        int i = 0;
        int j = 0;
        int sLen = originStr.length();
        int pLen = pattern.length();
        int[] next = getNext(pattern);
        while (i < sLen && j < pLen){
            if (j == -1 || originStr.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String pattern){
        char[] charArr = pattern.toCharArray();
        int[] next = new int[charArr.length];
        next[0] = -1;
        int i = -1;
        int j = 0;
        while (j < charArr.length - 1){
            //char[k]表示前缀，char[j]表示后缀
            if (i ==-1 || charArr[j] == charArr[i]){
                ++j;
                ++i;
                if(charArr[j] != charArr[i]){
                    next[j] = i;
                } else {
                    next[j] = next[i];
                }
            } else {
                i = next[i];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "substring searching algorithm";
        String pat = "search";
        System.out.println(solution(str,pat));
    }
}
