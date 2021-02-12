package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: willem
 * @create: 2021/02/12 15:59
 * @description: 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素 a，b，c，使得a+b+c=0？请你找出所有和为0且不重复的三元组
 */
public class No15 {
    /**
     * 时间复杂度：O(N^2)，其中N是数组的长度。
     * 空间复杂度：O(logN)。我们忽略存储答案的空间，额外的排序的空间复杂度为O(logN)。然而我们修改了输入的数组，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了
     * 的副本并进行排序，空间复杂度为O(N)
     * @param arr
     * @return
     */
    public static List<List<Integer>> solution(int[] arr){
        if (arr == null || arr.length < 3){
            return null;
        }
        int length = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        //一层循环
        for (int first = 0; first < length; first++) {
            // 需要和上一次枚举的数不相同
            if (first>0 && arr[first] == arr[first-1]){
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = length - 1;
            int target = -arr[first];
            //二层循环
            for (int second = first+1; second < length; second++) {
                // 需要和上一次枚举的数不相同
                if (second> first+1 && arr[second] == arr[second - 1]){
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && arr[second] + arr[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (arr[second] + arr[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[first]);
                    list.add(arr[second]);
                    list.add(arr[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = solution(arr);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> each = list.get(i);
            each.forEach(e-> System.out.println(e));
        }
    }
}
