package willem.weiyu.algorithm.leetCode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: willem
 * @create: 2019/08/13 23:57
 * @description: No1 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 */
//@Slf4j
public class No1 {


    /**
     *
     * @param nums
     * @param target
     *
     * 时间复杂度：O(n*n)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费O(n)的时间。因此时间复杂度为O(n*n)
     *
     * 空间复杂度：O(1)
     * @return
     */
    public static List<String> solution1(int[] nums, int target){
        List index = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    index.add(i+","+j);
                }
            }
        }
        return index;
    }

    /**
     *
     * @param nums
     * @param target
     * 时间复杂度：O(n)
     * 我们只遍历了包含有n个元素的列表一次。在表中进行的每次查找只花费O(1)的时间。
     *
     * 空间复杂度：O(n)
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储n个元素
     * @return
     */
    public static List<String> solution2(int[] nums, int target){
        List index = new ArrayList();
        Map<Integer, Integer> valueIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int diff = target - value;
            if (valueIndex.containsKey(diff) && valueIndex.get(diff) != i){
                index.add(i+","+valueIndex.get(diff));
            }
            valueIndex.put(nums[i], i);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 12, 5, 11, 1};
        int target = 12;
        //方法一
        System.out.println("******方法一******");
        solution1(nums, target).stream().forEach(item-> System.out.println(item));
        //方法二
        System.out.println("******方法二******");
        solution2(nums, target).stream().forEach(item-> System.out.println(item));
    }
}
