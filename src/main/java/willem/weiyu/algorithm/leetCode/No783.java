package willem.weiyu.algorithm.leetCode;

import willem.weiyu.algorithm.TreeNode;

/**
 * @Author willem
 * @Description 给你一个二叉搜索树的根节点root ，返回树中任意两不同节点值之间的最小差值
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * @Date 2021/4/13 14:27
 */
public class No783 {

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度；O(1)
     * @param root
     * @return
     */
    public static int solution(TreeNode root){
        if (root == null) {
            return -1;
        }
        return dfs(root, Integer.MAX_VALUE);
    }

    private static int dfs(TreeNode node,int min){
        if (node == null) {
            return min;
        }
        if (node.left != null && node.right != null){
            min = Math.min(min, Math.min(Math.abs(node.val - node.left.val), Math.abs(node.val - node.right.val)));
        } else if (node.left != null && node.right == null) {
            min = Math.min(min, Math.abs(node.val - node.left.val));
        } else if (node.left == null && node.right != null) {
            min = Math.min(min, Math.abs(node.val - node.right.val));
        }
        min = dfs(node.left, min);
        min = dfs(node.right, min);
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(6);
        TreeNode temp3 = new TreeNode(1);
        TreeNode temp4 = new TreeNode(3);
        root.left = temp1;
        root.right = temp2;
        temp1.left = temp3;
        temp1.right = temp4;
        System.out.println(solution(root));
    }
}
