package willem.weiyu.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @Author willem
 * @Description
 * @Date 2021/2/24 22:33
 */
public class Print {

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

    public static void printList(List<? extends Object> list){
        if (list == null || list.isEmpty()) {
            return;
        }
        list.stream().forEach(obj -> System.out.print(obj.toString()+","));
        System.out.println();
    }
}
