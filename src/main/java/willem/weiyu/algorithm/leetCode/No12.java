package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/09 21:37
 * @description: 整数转罗马数字(I->1,V->5,X->10,L->50,C->100,D->500,M->1000)
 */
public class No12 {

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String solution(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 12;
        System.out.println(solution(num));
        int num2 = 58;
        System.out.println(solution(num2));
    }
}
