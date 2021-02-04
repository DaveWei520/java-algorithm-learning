package willem.weiyu.algorithm.leetCode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: willem
 * @create: 2021/02/03 23:35
 * @description:
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
            System.out.println(node.getData());
            if (node.getRight() != null){
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inTraversal(TreeNode root){

    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraversal(TreeNode root){

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
            System.out.println(node.getData());
            if (node.getLeft() != null){
                queue.offer(node.left);
            }
            if (node.getRight() != null){
                queue.offer(node.getRight());
            }
        }
    }

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
        System.out.println("======level======");
        levelTraversal(root);
    }
}
