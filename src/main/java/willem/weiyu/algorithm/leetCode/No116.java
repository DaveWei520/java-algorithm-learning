package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;
import willem.weiyu.algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: willem
 * @create: 2021/03/03 14:56
 * @description: 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。填充它的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针设置为NULL。
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 */
public class No116 {

    /**
     * 时间复杂度：O(n)，n为节点的个数
     * 空间复杂度：O(mn)，m为深度，n为个数
     * @param root
     * @return
     */
    public static List<TreeNode> solution(TreeNode root){
        if (root == null){
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        append(result, queue);
        return result;
    }

    private static void append(List<TreeNode> list, Queue<TreeNode> nodeQueue){
        if (nodeQueue.isEmpty()){
            return;
        }
        TreeNode pre = new TreeNode();
        TreeNode cur = pre;
        Queue<TreeNode> queue = new ArrayDeque<>();
        while (!nodeQueue.isEmpty()){
            TreeNode temp = nodeQueue.poll();
            cur.next = temp;
            cur = temp;
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        list.add(pre.next);
        append(list, queue);
    }

    /**
     * 时间复杂度：O(N)。每个节点会被访问一次且只会被访问一次，即从队列中弹出，并建立next指针。
     * 空间复杂度：O(N)。这是一棵完美二叉树，它的最后一个层级包含N/2个节点。广度优先遍历的复杂度取决于一个层级上的最大元素数量。这种情况下空间复杂度为O(N)
     * @param root
     * @return
     */
    public static TreeNode solution2(TreeNode root){
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                TreeNode node = queue.poll();
                // 连接
                /*if (i < size - 1) {
                    node.next = queue.peek();
                }*/
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        /*
           1
          / \
         2   3
        / \ / \
       4  5 6  7
         */
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        List<TreeNode> list = solution(root);
        if (list != null && !list.isEmpty()){
            list.stream().forEach(each -> {
                TreeNode temp = each;
                while (temp != null){
                    System.out.print(temp.val+"#");
                    temp = temp.next;
                }
                System.out.println();
            });
        }

        TreeNode node = solution2(root);
        Utils.printLevelTree(node);
    }
}
