package com.jimmy.android.datastructurestudy.leetcode;

import org.junit.Test;


/**
 * 反转二叉树
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 返回 ：
 *   4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @return
 */
public class ExampleUnitTest5 {
    @Test
    public void addition_isCorrect() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node4.left = node2;
        node4.right = node7;

        node7.left=node9;
        node7.right=node6;

        node2.left = node3;
        node3.right = node1;

        TreeNode root = invertTree(node1);
        System.out.println("反转二叉树：==" + root.val);
    }

    /**
     * 递归
     * 这是一道很经典的二叉树问题。显然，我们从根节点开始，递归地对树进行遍历，并从叶子节点先开始翻转。如果当前遍历到的节点root
     * 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，即可完成以root 为根节点的整棵子树的翻转。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

