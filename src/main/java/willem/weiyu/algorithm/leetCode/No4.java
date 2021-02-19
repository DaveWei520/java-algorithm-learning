package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author willem
 * @Description No4 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数
 * @Date 2021/1/19 22:37
 */
public class No4 {

    public static float solution(List<Integer> list1,List<Integer> list2){
        List<Integer> totalList = new ArrayList<>();
        totalList.addAll(list1);
        totalList.addAll(list2);
        totalList = totalList.stream().sorted().collect(Collectors.toList());
        System.out.println("======sortedList"+totalList.toString());
        int index = totalList.size()/2;
        int num = totalList.size()%2;
        return num == 0 ? ((float)totalList.get(index-1) + (float)totalList.get(index))/2:totalList.get(index);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList(){{
            add(2);
            add(5);
            add(9);
        }};
        List<Integer> list2 = new ArrayList(){{
            add(3);
            add(6);
            add(8);
        }};
        System.out.println(solution(list1,list2));
    }
}
