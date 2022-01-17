package com.jimmy.android.datastructurestudy.leetcode;

import org.junit.Test;


/**
 * 二叉树遍历
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例
 *    1
 *     \
 *      2
 *     /
 *    3
 * 返回 ：
 * 1，3，2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @return
 */
public class ExampleUnitTest6 {
    @Test
    public void addition_isCorrect() {
        TreeNode<String> root=new TreeNode<>("A",null,null);
        TreeNode<String> TreeNodeB=new TreeNode<String>("B",null,null);
        TreeNode<String> TreeNodeC=new TreeNode<String>("C",null,null);
        TreeNode<String> TreeNodeD=new TreeNode<String>("D",null,null);
        TreeNode<String> TreeNodeE=new TreeNode<String>("E",null,null);
        TreeNode<String> TreeNodeF=new TreeNode<String>("F",null,null);
        TreeNode<String> TreeNodeG=new TreeNode<String>("G",null,null);
        TreeNode<String> TreeNodeH=new TreeNode<String>("H",null,null);
        TreeNode<String> TreeNodeJ=new TreeNode<String>("J",null,null);
        TreeNode<String> TreeNodeI=new TreeNode<String>("I",null,null);
        root.leftChild=TreeNodeB;
        root.rightChild=TreeNodeC;
        TreeNodeB.leftChild=TreeNodeD;
        TreeNodeC.leftChild=TreeNodeE;
        TreeNodeC.rightChild=TreeNodeF;
        TreeNodeD.leftChild=TreeNodeG;
        TreeNodeD.rightChild=TreeNodeH;
        TreeNodeE.rightChild=TreeNodeJ;
        TreeNodeH.leftChild=TreeNodeI;


        midOrderTraverse(root);
        preOrderTraverse(root);
        postOrderTraverse(root);
    }



    /**
     * 中序访问树的所有节点
     */
    public void midOrderTraverse(TreeNode root){//逻辑
        if(root==null){
            return;
        }
        midOrderTraverse(root.leftChild);//逻辑
        System.out.println("mid:"+root.data);//输出
        midOrderTraverse(root.rightChild);//逻辑
    }
    /**
     * 前序访问树的所有节点  Arrays.sort();
     */
    public void preOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println("pre:"+root.data);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }
    /**
     * 后序访问树的所有节点
     */
    public void postOrderTraverse(TreeNode root){
        if(root==null){
            return;
        }
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println("post:"+root.data);
    }



    public class TreeNode<T> {

        T data;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;

        TreeNode() {
        }

        TreeNode(T val) {
            this.data = val;
        }

        TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
            this.data = val;
            this.leftChild = left;
            this.rightChild = right;
        }
    }

}

