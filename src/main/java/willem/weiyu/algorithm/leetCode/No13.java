package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/09 21:59
 * @description: 罗马数字转整数
 */
public class No13 {

    public static int solution(String str){
        int result = 0;
        if (str == null || str.length() < 1){
            return result;
        }
        int sum = 0;
        int pre = getVal(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val = getVal(ch);
            if (pre < val){
                sum -=pre;
            } else {
                sum+=pre;
            }
            pre = val;
        }
        sum +=pre;
        return sum;
    }

    private static int getVal(char ch){
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String str = "III";
        System.out.println(solution(str));
        String str2 = "MCMXCIV";
        System.out.println(solution(str2));
    }
}
