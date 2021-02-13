package willem.weiyu.algorithm.leetCode;

import java.util.Arrays;

/**
 * @author: willem
 * @create: 2021/02/13 16:32
 * @description: 给定一个包括n个整数的数组nums和一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案
 *
 */
public class No16 {

    /**
     * 时间复杂度：O(N^2)，其中是数组的长度。我们首先需要O(NlogN)的时间对数组进行排序，随后在枚举的过程中，使用一重循环 O(N)枚举a，双指针O(N)枚举b和c，故一共是O(N^2)
     * 空间复杂度：O(logN)。排序需要使用O(logN) 的空间。然而我们修改了输入的数组nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了nums的副本并进行排序，此时空间复杂度为O(N)
     * @param arr
     * @param target
     * @return
     */
    public static int solution(int[] arr, int target){
        int result = 0;
        if (arr.length < 4) {
            for (int i = 0; i < arr.length; i++) {
                result += arr[i];
            }
            return result;
        }
        Arrays.sort(arr);
        int length = arr.length;
        int best = Integer.MAX_VALUE;

        // 枚举 a
        for (int i = 0; i < length; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && arr[k0] == arr[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && arr[j0] == arr[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,44};
        int target = 1;
        System.out.println(solution(arr, target));
    }
}
