package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: willem
 * @create: 2021/02/03 23:35
 * @description: 树的遍历一般分为前序遍历、中序遍历、后序遍历、层序遍历。图的遍历分为深度优先遍历（前/中/后序遍历）、广度优先遍历（层序遍历）
 */
public class TraversalTree {

    /**
     * 前序遍历
     * @param root
     */
    public static void preTraversalRecursion(TreeNode root){
        System.out.print(root.getVal()+"->");
        preTraversalRecursion(root.getLeft());
        preTraversalRecursion(root.getRight());
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.getVal()+"->");
            if (node.getRight() != null){
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        System.out.println("");
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraversalRecursion(TreeNode root){
        inTraversalRecursion(root.getLeft());
        System.out.print(root.getVal()+"->");
        inTraversalRecursion(root.getRight());
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            //入栈所有做节点
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            System.out.print(node.getVal()+"->");
            //指向当前节点的右节点
            node = node.getRight();

        }
        System.out.println("");
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraversalRecursion(TreeNode root){
        postTraversalRecursion(root.getLeft());
        postTraversalRecursion(root.getRight());
        System.out.print(root.getVal()+"->");
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraversal(TreeNode root){
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.getLeft() == null && cur.getRight() == null) || (pre != null && (pre == cur.getLeft() || pre == cur.getRight()))) {
                System.out.print(cur.getVal() + "->");
                pre = stack.pop();
            } else {
                if (cur.getRight() != null){
                    stack.push(cur.getRight());
                }

                if (cur.getLeft() != null){
                    stack.push(cur.getLeft());
                }
            }
        }
        System.out.println("");
    }

    /**
     * 层序遍历
     * @param root
     */
    public static void levelTraversal(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.getVal()+"->");
            if (node.getLeft() != null){
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null){
                queue.offer(node.getRight());
            }
        }
        System.out.println("");
    }

    /**
     *      1
     *    /  \
     *   2   3
     *  /\  /\
     * 4 5 6 7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setVal(1);

        TreeNode two = new TreeNode();
        two.setVal(2);

        TreeNode three = new TreeNode();
        three.setVal(3);

        TreeNode four = new TreeNode();
        four.setVal(4);

        TreeNode five = new TreeNode();
        five.setVal(5);

        TreeNode six = new TreeNode();
        six.setVal(6);

        TreeNode seven = new TreeNode();
        seven.setVal(7);
        root.setLeft(two);
        root.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        three.setRight(seven);

        System.out.println("======pre======");
        preTraversal(root);
        System.out.println("======in======");
        inTraversal(root);
        System.out.println("======post======");
        postTraversal(root);
        System.out.println("======level======");
        levelTraversal(root);
    }
}
