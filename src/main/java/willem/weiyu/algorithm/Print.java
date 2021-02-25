package willem.weiyu.algorithm;

import java.util.Arrays;

/**
 * @Author willem
 * @Description
 * @Date 2021/2/24 22:33
 */
public class Print {

    public static void printArr(Object[] objArr){
        if (objArr == null || objArr.length < 1){
            return;
        }
        Arrays.stream(objArr).forEach(obj-> System.out.print(obj.toString()+","));
        System.out.println("");
    }

    public static void printMultiArr(Object[][] objArr){
        if (objArr == null || objArr.length < 1){
            return;
        }
        for (Object[] obj : objArr) {
            if (obj == null || obj.length < 1){
                continue;
            }
            for (Object o : obj) {
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
            System.out.print(cur.getVal()+"=>");
            if (cur.getNext() == null){
                break;
            }
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void swap(Object[] obj, int from, int to) {
        Object temp = obj[from];
        obj[from] = obj[to];
        obj[to] = temp;
    }

}
