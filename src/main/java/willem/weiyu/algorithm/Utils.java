package willem.weiyu.algorithm;

import java.util.*;

/**
 * @Author willem
 * @Description
 * @Date 2021/2/24 22:33
 */
public class Utils {

    public static <T extends Object> void printArr(T[] objArr){
        if (objArr == null || objArr.length < 1){
            return;
        }
        Arrays.stream(objArr).forEach(obj-> System.out.print(obj.toString()+","));
        System.out.println("");
    }

    public static <T extends Object> void printMultiArr(T[][] objArr){
        if (objArr == null || objArr.length < 1){
            return;
        }
        for (T[] obj : objArr) {
            if (obj == null || obj.length < 1){
                continue;
            }
            for (T o : obj) {
                System.out.print(o.toString()+",");
            }
            System.out.println("");
        }
    }

    public static void printArr(int[] objArr){
        if (objArr == null || objArr.length < 1){
            return;
        }
        Arrays.stream(objArr).forEach(obj-> System.out.print(obj+","));
        System.out.println("");
    }

    public static void printMultiArr(int[][] intArr){
        if (intArr == null || intArr.length < 1){
            return;
        }
        for (int[] intA : intArr) {
            if (intA == null || intA.length < 1){
                continue;
            }
            for (int o : intA) {
                System.out.print(o+",");
            }
            System.out.println("");
        }
    }

    public static void printListNode(ListNode node){
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

    public static <T extends Object> void swap(T[] obj, int from, int to) {
        T temp = obj[from];
        obj[from] = obj[to];
        obj[to] = temp;
    }

    public static void swapInt(int[] arr, int from, int to) {
        arr[from] = arr[from]^arr[to];
        arr[to] = arr[from]^arr[to];
        arr[from] = arr[from]^arr[to];
    }

    public static void printList(List<? extends Object> list){
        if (list == null || list.isEmpty()) {
            return;
        }
        list.stream().forEach(obj -> System.out.print(obj.toString()+","));
        System.out.println();
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void printPreTree(TreeNode node){
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(node);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.pop();
            System.out.print(temp.val+"->");
            if (temp.right != null){
                deque.push(temp.right);
            }
            if (temp.left != null){
                deque.push(temp.left);
            }
        }
        System.out.println();
    }

    /**
     * 层序遍历
     * @param node
     */
    public static void printLevelTree(TreeNode node){
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.val+"->");
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }
        System.out.println("");
    }
}
