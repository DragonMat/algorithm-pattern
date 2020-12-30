package data.structure.binarytree.algorithm;

import data.structure.binarytree.model.BinaryTree;
import data.structure.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public class BinaryTreeTraversal {


    /**
     * 先序遍历（递归） 根结点 ---> 左子树 ---> 右子树
     * @param root
     */
    public void preorderTraversalRecursion(TreeNode root){

        if ( root != null){
            System.out.println(root.getValue()+" ");
            preorderTraversalRecursion(root.getLeftChild());
            preorderTraversalRecursion(root.getRightChild());
        }

    }

    /**
     * 先序遍历（非递归） 根结点 ---> 左子树 ---> 右子树
     * @param root
     */
    public void preorderTraversal(TreeNode root){
        Stack<TreeNode> tempNode = new Stack<>();
        TreeNode currentNode = root;

        while(currentNode != null || !tempNode.isEmpty()){

            //左子树
            while(currentNode !=null){
                System.out.println(currentNode.getValue());
                tempNode.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            //右子树
            currentNode = tempNode.pop().getRightChild();
        }

    }

    /**
     * 中序遍历（递归） 左子树---> 根结点 ---> 右子树
     * @param root
     */
    public void inorderTraversalRecursion(TreeNode root){

        if ( root != null){
            inorderTraversalRecursion(root.getLeftChild());
            System.out.println(root.getValue()+" ");
            inorderTraversalRecursion(root.getRightChild());
        }

    }

    /**
     * 中序遍历（递归） 左子树---> 根结点 ---> 右子树
     * @param root
     */
    public void inorderTraversal(TreeNode root){

        Stack<TreeNode> tempNode = new Stack<>();
        TreeNode currentNode = root;

        while(currentNode != null || !tempNode.isEmpty()){

            while(currentNode !=null){
                tempNode.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            TreeNode popNode = tempNode.pop();
            System.out.println(popNode.getValue());
            currentNode = popNode.getRightChild();
        }

    }

    /**
     * 后序遍历（递归） 左子树 ---> 右子树 ---> 根结点
     * @param root
     */
    public void postorderTraversalRecursion(TreeNode root){

        if ( root != null){
            postorderTraversalRecursion(root.getLeftChild());
            postorderTraversalRecursion(root.getRightChild());
            System.out.println(root.getValue()+" ");
        }

    }

    /**
     * 后序遍历（非递归） 左子树 ---> 右子树 ---> 根结点
     * @param root
     */
    public static void postorderTraversal(TreeNode root){

        Stack<TreeNode> tempNode = new Stack<>();
        TreeNode currentNode = root;
        TreeNode preNode = null;


        while(currentNode != null || !tempNode.isEmpty()){

            //左子树
            while(currentNode !=null){
                tempNode.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            TreeNode popNode = tempNode.pop();
            currentNode = popNode.getRightChild();
            //当前节点右子树不为空（1.还未遍历右子树；2.已经遍历过右子树了，通过preNode是否与当前右子树根结点相同来判断）
            if (currentNode != null && preNode != popNode.getRightChild()){
                tempNode.push(popNode);
            }else {
                System.out.println(popNode.getValue());
                //记录打印的值
                preNode = popNode;
                currentNode = null;
            }
        }

    }

    public static void main(String[] args) {
        /**
         *    1
         *       2
         *     3  4
         */
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node01 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node0.setLeftChild(node2);
        node0.setRightChild(node4);
        node2.setLeftChild(node1);
        node4.setLeftChild(node3);
        node4.setRightChild(node01);
        node1.setLeftChild(node5);
        node1.setRightChild(node11);
        node3.setRightChild(node6);
        node01.setRightChild(node8);

//        node1.setRightChild(node2);
//        node2.setLeftChild(node3);
//        node2.setRightChild(node4);
//        postorderTraversal(node1);

        //[0,2,4,1,null,3,-1,5,1,null,6,null,8]
        BinaryTree tree = new BinaryTree(node0);
        System.out.println(tree.hight());
    }
}
