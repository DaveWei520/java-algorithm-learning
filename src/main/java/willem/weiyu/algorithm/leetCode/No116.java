package willem.weiyu.algorithm.leetCode;

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
    }
}
