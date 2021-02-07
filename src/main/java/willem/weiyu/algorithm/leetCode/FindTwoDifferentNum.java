package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/07 15:54
 * @description:
 */
public class FindTwoDifferentNum {

    public static int[] solution(int[] arr){
        int[] result = new int[2];
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val ^= arr[i];
        }
        //异或结果从右向左第一个1的位置
        int pos = 0;
        while ( (val & 1) == 0){
            pos++;
            val = val >> 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i]>> pos & 1) == 1){
                result[0] ^= arr[i];
            } else {
                result[1] ^= arr[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{12,30,25,12,2,30};
        int[] result = solution(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
