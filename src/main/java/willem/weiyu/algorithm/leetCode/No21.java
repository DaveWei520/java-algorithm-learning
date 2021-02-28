package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.ListNode;
import willem.weiyu.algorithm.Print;

/**
 * @author: willem
 * @create: 2021/02/28 16:06
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 */
public class No21 {

    /**
     * 时间复杂度：O(m+n),m，n分别为两个链表的长度
     * 空间复杂度：O(1)
     * @param node
     * @param other
     * @return
     */
    public static ListNode solution(ListNode node, ListNode other){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (node != null || other != null){
            if (node == null){
                cur.setNext(other);
                cur = other;
                other = other.getNext();
                continue;
            }
            if (other == null) {
                cur.setNext(node);
                cur = node;
                node = node.getNext();
                continue;
            }
            if (node.getVal() < other.getVal()){
                cur.setNext(node);
                cur = node;
                node = node.getNext();
            } else if (node.getVal() > other.getVal()){
                cur.setNext(other);
                cur = other;
                other = other.getNext();
            } else {
                cur.setNext(node);
                cur = node;
                cur.setNext(other);
                cur = other;
            }
        }
        return head.getNext();
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.setNext(three);
        three.setNext(five);
        two.setNext(four);
        four.setNext(six);
        Print.printListNode(solution(one,two));
    }
}
