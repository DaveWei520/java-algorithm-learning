package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.ListNode;
import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/02/26 15:33
 * @description: 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。k是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class No25 {

    /**
     * 时间复杂度：O()
     * 空间复杂度：O(1)
     * @param node
     * @param k
     * @return
     */
    public static ListNode solution(ListNode node, int k){
        if (node == null) {
            return null;
        }
        ListNode head, tail;
        head = tail = node;
        for (int i = 0; i < k; i++) {
            if (tail == null){
                return node;
            }
            tail = tail.getNext();
        }
        ListNode newHead = reverse(head, tail);
        head.setNext(solution(tail, k));
        return newHead;
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre, cur, nxt;
        pre = null; cur = head; nxt = head;
        // while 终止的条件改一下就行了
        while (cur != tail) {
            nxt = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        int k = 3;
        System.out.println("翻转之前===");
        Print.printListNode(one);
        System.out.println("翻转之后===");
        Print.printListNode(solution(one, k));
    }
}
