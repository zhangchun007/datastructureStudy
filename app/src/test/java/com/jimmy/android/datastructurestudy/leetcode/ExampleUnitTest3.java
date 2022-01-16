package com.jimmy.android.datastructurestudy.leetcode;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 示例：
 * 1 、
 * 输入：root=[1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 2 、
 * 输入：root=[]
 * 输出：[]
 * <p>
 * <p>
 * 3、
 * 输入：root=[1]
 * 输出：[1]
 * <p>
 * 4、
 * 输入：root=[1,2]
 * 输出：[2,1]
 * <p>
 * 5、
 * 输入：root=[1,null,2]
 * 输出：[1,2]
 *
 * @return
 */
public class ExampleUnitTest3 {
    @Test
    public void addition_isCorrect() {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);

        node1.right = node2;
        node2.left = node3;

        //二叉树中序遍历
        inorderTraversal(node1, "mid");

        //二叉树前序遍历
        inorderTraversal(node1, "pre");

        //二叉树前序遍历
        inorderTraversal(node1, "post");


    }

    public List<Integer> inorderTraversal(TreeNode root, String type) {
        List<Integer> res = new ArrayList<>();
        if (type == "mid") {
            midOrder(root, res);
        } else if (type == "pre") {
            preOrderTraverse(root, res);
        } else if (type == "post") {
            postOrderTraverse(root, res);
        }
        return res;
    }

    /**
     * 二叉树中序遍历
     *
     * @param root
     * @param res
     */
    private void midOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        midOrder(root.left, res);
        res.add(root.val);
        System.out.println("二叉树的中序遍历：==" + root.val);
        midOrder(root.right, res);
    }

    /**
     * 二叉树中序遍历
     *
     * @param root
     * @param res
     */
    private void preOrderTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        System.out.println("pre:" + root.val);
        preOrderTraverse(root.left, res);
        preOrderTraverse(root.right, res);
    }

    /**
     * 后序访问树的所有节点
     */
    public void postOrderTraverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left,res);
        postOrderTraverse(root.right,res);
        System.out.println("post:" + root.val);
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

