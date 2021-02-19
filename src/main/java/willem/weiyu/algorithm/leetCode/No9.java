package willem.weiyu.algorithm.leetCode;

/**
 * @Author willem
 * @Description No9 给你一个整数x ，如果x是一个回文整数，返回ture；否则，返回false
 * @Date 2021/2/4 22:18
 */
public class No9 {
    /**
     * 将数字对折一半，如果为回文数，肯定相等
     * @param num
     * @return
     */
    public static boolean solution(int num){
        if (num < 0){
            return false;
        }
        boolean odd = num%2 == 0?false:true;
        int head = num;
        int tail = 0;
        int a = num;
        int length = 0;
        while (a > 0){
            length++;
            a /=10;
        }
        for (int i = 0; i < length/2; i++) {
            int temp = head%10;
            head/= 10;
            tail = tail*10+temp;
        }
        if (odd){
            head/=10;
        }
        return head == tail;
    }
    public static void main(String[] args) {
        System.out.println(solution(123321));
    }
}
