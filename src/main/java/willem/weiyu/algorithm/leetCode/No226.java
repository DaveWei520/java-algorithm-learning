package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.Print;
import willem.weiyu.algorithm.TreeNode;

/**
 * @author: willem
 * @create: 2021/03/03 14:23
 * @description: 翻转一棵二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree
 */
public class No226 {

    /**
     * 时间复杂度：O(n)，n为节点的个数
     * 空间复杂度：O(n)，n为节点的个数
     * @param root
     * @return
     */
    public static TreeNode solution(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        solution(root.left);
        solution(root.right);
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
        System.out.println("翻转前===");
        Print.printLevelTree(root);
        System.out.println("翻转后===");
        Print.printLevelTree(solution(root));
    }
}
