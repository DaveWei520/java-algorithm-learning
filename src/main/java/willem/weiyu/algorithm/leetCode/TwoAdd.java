package willem.weiyu.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiyu005@ke.com
 * @Description No2 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示和的链表
 * 示例  2->4->3
 *      5->6->4
 * ------------------
 *      7->0->8
 * @Date 2021/1/18 23:06
 */
public class TwoAdd {

    public static List<Integer> solution1(List<Integer> list1, List<Integer> list2){
        int len1 = list1.size();
        int len2 = list2.size();
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                list1.add(0);
            }
        } else if(len1 > len2){
            for (int i = 0; i < len1 - len2; i++) {
                list2.add(0);
            }
        }
        int total = list1.size();
        List<Integer> result = new ArrayList<>();
        //是否进位
        boolean flag = false;
        for (int i = 0; i < total; i++) {
            Integer temp = 0;
            int l1 = list1.get(i);
            int l2 = list2.get(i);
            int sum = l1 + l2;
            if (sum >= 10) {
                flag = true;
                temp = sum % 10;
            } else {
                temp = sum;
            }
            if (flag){
                if (i > 0) {
                    temp += 1;
                    if (temp >=10){
                        temp = 0;
                        flag = true;
                    } else {
                        flag = false;
                    }
                }
            }
            result.add(temp);
        }
        if (flag){
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList(){{
            add(7);
            add(2);
            add(1);
            add(3);
        }};
        List<Integer> l2 = new ArrayList(){{
            add(4);
            add(9);
            add(0);
            add(1);
        }};
        System.out.println(solution1(l1,l2));
    }
}
