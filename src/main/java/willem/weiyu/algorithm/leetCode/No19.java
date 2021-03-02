package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.ListNode;
import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/02/21 16:01
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class No19 {
    /**
     * 将倒数n变为正向，并让需要删除的节点，其前驱节点指向其后续节点
     * 时间复杂度：O(n)，n为链表的长度
     * 空间复杂度：O(1)，仅开辟一个定位的临时节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode solution(ListNode head, int n){
        int len = getLen(head);
        int index = len - n;
        if (index < 0){
            return null;
        }
        ListNode deleteNode = head;
        for (int i = 0; i < index - 1; i++) {
            deleteNode = deleteNode.next;
        }
        deleteNode.next = deleteNode.next.next;
        return head;
    }

    private static int getLen(ListNode head){
        int len = 0;
        if (head == null) {
            return len;
        } else {
            len++;
        }
        ListNode count = head;
        while (count.next != null){
            len ++;
            count = count.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        int n = 3;

        ListNode node = solution(one, n);
        Print.printListNode(node);
        System.out.println();
    }
}