package willem.weiyu.algorithm.leetCode;

/**
 * @Author weiyu005@ke.com
 * @Description No8 将字符串转换成一个 32 位有符号整数
 * @Date 2021/2/2 22:34
 */
public class No8 {

    public static int solution(String str){
        str = str.trim();
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = str.toCharArray();
        boolean isNegative = false;
        int result = 0;
        for (int i = 0; i < charArr.length; i++) {
            char temp = charArr[i];
            int a = temp - '0';
            if (temp == '-'){
                isNegative = true;
                continue;
            } else if (temp == '+'){
                isNegative = false;
                continue;
            } else if (a < 0 || a > 9){
                break;
            }
            result = result*10+a;
        }
        if (result != 0 && isNegative){
            result = -result;
        }
        if (result< Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }
        if (result > Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "-123";
        System.out.println(solution(str));

        String str2 = "   -42";
        System.out.println(solution(str2));

        String str3 = "4193 with words";
        System.out.println(solution(str3));

        String str4 = "words and 987";
        System.out.println(solution(str4));

        String str5 = "-91283472332";
        System.out.println(solution(str5));
    }
}
