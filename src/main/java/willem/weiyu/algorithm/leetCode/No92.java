package willem.weiyu.algorithm.leetCode;

/**
 * @author: willem
 * @create: 2021/02/23 12:47
 * @description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class No92 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 时间复杂度：O(n)，n为链表长度
     * 空间复杂度：O(1)
     * @param head
     * @param m
     * @param n
     */
    public static void solution(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
    }

    public static void print(ListNode node){
        if (node == null){
            return;
        }
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val+"=>");
            if (cur.next == null){
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        System.out.println("反转前======");
        print(one);
        System.out.println("反转后======");
        solution(one,2,4);
        print(one);
    }
}
