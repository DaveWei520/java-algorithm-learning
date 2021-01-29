package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/01/29 17:02
 * @description: 给定一个数组，颠倒其顺序并输出
 */
public class ReverseArr {

    public static void solution(int[] arr, int head, int end){
        if (head >= end){
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            return;
        }
        int temp = arr[head];
        arr[head] = arr[end];
        arr[end] = temp;
        solution(arr, ++head, --end);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        solution(arr,0,arr.length - 1);
    }
}
