package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.ListNode;
import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/03/04 12:25
 * @description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */
public class No24 {

    /**
     * 时间复杂度：O(n)，n为链表的长度
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head){
        if (head == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        System.out.println("交换之前");
        Print.printListNode(one);
        System.out.println("交换之后");
        Print.printListNode(solution(one));
    }
}
