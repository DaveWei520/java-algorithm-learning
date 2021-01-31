package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/01/31 14:08
 * @description: No7 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果
 */
public class ReverseInt {

    public static int solution(int x){
        int result = 0;
        while (x !=0){
            int num = x%10;
            x /= 10;
            result = result * 10 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 123456;
        System.out.println(solution(x));
    }
}
