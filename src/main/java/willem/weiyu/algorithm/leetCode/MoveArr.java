package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/01/29 16:45
 * @description: 给定一个数组，及左移位数，输出移动后数组元素
 */
public class MoveArr {

    public static void solution(int[] arr, int step){
        int offset = 0;
        if (arr.length >= step){
            offset = step;
        } else {
            offset = step - step/arr.length * arr.length;
        }
        for (int i = 0; i < offset; i++) {
            int temp = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j+1];
            }
            arr[arr.length -1] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int step = 17;
        solution(arr,step);
    }
}
