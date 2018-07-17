package willem.weiyu.algorithm.recursion;

/**
 * @author weiyu@gomefinance.com.cn
 * @description 递归打印数组全排列
 * @create 2018/7/17 14:59
 * @since 1.0.0
 */
public class RecursionTree {

    public static void permutation(char[] arr, int from, int to){
        if (to < 1)
            return;
        if (from == to) {
            System.out.println(arr);
        }else{
            for (int i=from; i<=to; i++){
                swap(arr, i, from);
                permutation(arr, from+1, to);
                swap(arr, from, i);
            }
        }
    }

    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd'};
        permutation(arr,0, arr.length-1);
    }
}
