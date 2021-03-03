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
        System.out.print(root.val+"->");
        preTraversalRecursion(root.left);
        preTraversalRecursion(root.right);
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
            System.out.print(node.val+"->");
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println("");
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraversalRecursion(TreeNode root){
        inTraversalRecursion(root.left);
        System.out.print(root.val+"->");
        inTraversalRecursion(root.right);
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
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.val+"->");
            //指向当前节点的右节点
            node = node.right;

        }
        System.out.println("");
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraversalRecursion(TreeNode root){
        postTraversalRecursion(root.left);
        postTraversalRecursion(root.right);
        System.out.print(root.val+"->");
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
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val + "->");
                pre = stack.pop();
            } else {
                if (cur.right != null){
                    stack.push(cur.right);
                }

                if (cur.left != null){
                    stack.push(cur.left);
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
            System.out.print(node.val+"->");
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
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
        root.val = 1;

        TreeNode two = new TreeNode();
        two.val = 2;

        TreeNode three = new TreeNode();
        three.val = 3;

        TreeNode four = new TreeNode();
        four.val = 4;

        TreeNode five = new TreeNode();
        five.val = 5;

        TreeNode six = new TreeNode();
        six.val = 6;

        TreeNode seven = new TreeNode();
        seven.val = 7;

        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

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
