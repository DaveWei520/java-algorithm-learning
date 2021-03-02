package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.ListNode;
import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/03/02 19:54
 * @description: 给你一个链表数组，每个链表都已经按升序排列，请你将所有链表合并到一个升序链表中，返回合并后的链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class No23 {

    /**
     *
     * @param list
     * @return
     */
    public static ListNode solution(ListNode[] list){
        if (list == null || list.length < 1){
            return null;
        }
        ListNode[] cursor = new ListNode[list.length];
        for (int i = 0; i < list.length; i++) {
            cursor[i] = list[i];
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (true){
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for (int i = 0; i < cursor.length; i++) {
                if (cursor[i] == null){
                    continue;
                }
                if(cursor[i].val <= min.val){
                    min = cursor[i];
                    index = i;
                }
            }
            if (index != -1){
                cur.next = cursor[index];
                cursor[index] = cursor[index].next;
                cur = cur.next;
            } else {
                break;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode first2 = new ListNode(4);
        ListNode first3 = new ListNode(5);
        first.next = first2;
        first2.next = first3;

        ListNode second = new ListNode(1);
        ListNode second2 = new ListNode(3);
        ListNode second3 = new ListNode(4);
        second.next = second2;
        second2.next = second3;

        ListNode third = new ListNode(2);
        ListNode third2 = new ListNode(6);
        third.next = third2;

        ListNode[] list = new ListNode[]{first, second, third};
        Print.printListNode(solution(list));
    }
}