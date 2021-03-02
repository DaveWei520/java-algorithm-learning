package willem.weiyu.algorithm;

import java.util.Objects;

/**
 * @Author willem
 * @Description
 * @Date 2021/2/24 23:15
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){

    }
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{val=" + val +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
