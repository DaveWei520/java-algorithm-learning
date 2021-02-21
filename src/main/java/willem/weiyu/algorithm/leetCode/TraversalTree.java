package willem.weiyu.algorithm.leetCode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: willem
 * @create: 2021/02/03 23:35
 * @description: 树的遍历一般分为前序遍历、中序遍历、后序遍历、层序遍历。图的遍历分为深度优先遍历（前/中/后序遍历）、广度优先遍历（层序遍历）
 */
public class TraversalTree {
    public static class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
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
            System.out.print(node.getData()+"->");
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
    public static void inTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.data+"->");
                node = tem.right;
            }
        }
        System.out.println("");
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
                System.out.print(cur.data + "->");
                stack.pop();
                pre = cur;
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
            System.out.print(node.getData()+"->");
            if (node.getLeft() != null){
                queue.offer(node.left);
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
        root.setData(1);

        TreeNode two = new TreeNode();
        two.setData(2);

        TreeNode three = new TreeNode();
        three.setData(3);

        TreeNode four = new TreeNode();
        four.setData(4);

        TreeNode five = new TreeNode();
        five.setData(5);

        TreeNode six = new TreeNode();
        six.setData(6);

        TreeNode seven = new TreeNode();
        seven.setData(7);
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
