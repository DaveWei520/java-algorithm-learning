package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Utils;
import willem.weiyu.algorithm.TreeNode;

/**
 * @author: willem
 * @create: 2021/03/04 15:01
 * @description:给你二叉树的根结点root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用TreeNode ，其中right子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class No114 {

    /**
     * 时间复杂度：O(n),n为节点的个数
     * 空间复杂度：O(1)
     * @param root
     */
    public static void solution(TreeNode root){
        // base case
        if (root == null) {
            return;
        }
        solution(root.left);
        solution(root.right);

        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        /*
           1
          / \
         2   5
        / \   \
       3  4    6
         */
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = five;
        two.left = three;
        two.right = four;
        five.right = six;
        System.out.println("展开前");
        Utils.printPreTree(root);
        System.out.println("展开后");
        solution(root);
        Utils.printPreTree(root);
    }
}
