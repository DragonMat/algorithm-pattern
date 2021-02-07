package data.structure.binarytree.algorithm;

import data.structure.binarytree.model.BinaryTree;
import data.structure.binarytree.model.TreeNode;

import java.util.*;

public class BinaryTreeTraversal {


    /**
     * 先序遍历（递归） 根结点 ---> 左子树 ---> 右子树
     *
     * @param root
     */
    public void preorderTraversalRecursion(TreeNode root) {

        if (root != null) {
            System.out.println(root.getValue() + " ");
            preorderTraversalRecursion(root.getLeftChild());
            preorderTraversalRecursion(root.getRightChild());
        }

    }

    /**
     * 先序遍历（非递归） 根结点 ---> 左子树 ---> 右子树
     *
     * @param root
     */
    public void preorderTraversal(TreeNode root) {
        Stack<TreeNode> tempNode = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !tempNode.isEmpty()) {

            //左子树
            while (currentNode != null) {
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
     *
     * @param root
     */
    public void inorderTraversalRecursion(TreeNode root) {

        if (root != null) {
            inorderTraversalRecursion(root.getLeftChild());
            System.out.println(root.getValue() + " ");
            inorderTraversalRecursion(root.getRightChild());
        }

    }

    /**
     * 中序遍历（非递归） 左子树---> 根结点 ---> 右子树
     *
     * @param root
     */
    public void inorderTraversal(TreeNode root) {

        Stack<TreeNode> tempNode = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !tempNode.isEmpty()) {

            while (currentNode != null) {
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
     *
     * @param root
     */
    public void postorderTraversalRecursion(TreeNode root) {

        if (root != null) {
            postorderTraversalRecursion(root.getLeftChild());
            postorderTraversalRecursion(root.getRightChild());
            System.out.println(root.getValue() + " ");
        }

    }

    /**
     * 后序遍历（非递归） 左子树 ---> 右子树 ---> 根结点
     *
     * @param root
     */
    public static void postorderTraversal(TreeNode root) {

        Stack<TreeNode> tempNode = new Stack<>();
        TreeNode currentNode = root;
        TreeNode preNode = null;


        while (currentNode != null || !tempNode.isEmpty()) {

            //左子树
            while (currentNode != null) {
                tempNode.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            TreeNode popNode = tempNode.pop();
            currentNode = popNode.getRightChild();
            //当前节点右子树不为空（1.还未遍历右子树；2.已经遍历过右子树了，通过preNode是否与当前右子树根结点相同来判断）
            if (currentNode != null && preNode != popNode.getRightChild()) {
                tempNode.push(popNode);
            } else {
                System.out.println(popNode.getValue());
                //记录打印的值
                preNode = popNode;
                currentNode = null;
            }
        }

    }

    /**
     * 后序遍历（递归） 左子树 ---> 右子树 ---> 根结点
     *
     * @param root
     */
    public void maxPathNum(TreeNode root) {

        if (root != null) {
            maxPathNum(root.getLeftChild());
            maxPathNum(root.getRightChild());
            System.out.println(root.getValue());

        }
    }

    private int  maxSum = Integer.MIN_VALUE;

    /**
     * 给你一个二叉树的根节点 root ，返回其最大路径和。
     *
     * @param root
     * @return
     */
    public  int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public  int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.getLeftChild()), 0);
        int rightGain = Math.max(maxGain(node.getRightChild()), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.getValue() + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值（只能选择一边，对于它的父节点而言，这条路径要么经过当前节点的左孩子，要么经过右孩子）
        return node.getValue() + Math.max(leftGain, rightGain);
    }

//    public  int maxPathSum2(TreeNode root) {
//        int result = maxPathSumCount(root);
//        return Math.max(maxSum,result);
//    }
//
//    public  int maxPathSumCount(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftMax = Math.max(maxPathSumCount(root.getLeftChild()), 0);
//        int rightMax = Math.max(maxPathSumCount(root.getRightChild()), 0);
//        maxSum = Math.max((root.getValue() + leftMax + rightMax) , maxSum);
//        return root.getValue() +  Math.max(leftMax, rightMax);
//    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null){
//            return null;
//        }
//
//        Stack<TreeNode> result1 = new Stack<>();
//        Stack<TreeNode> result2 = new Stack<>();
//        getAllAncestor(root,p,result1);
//        getAllAncestor(root,q,result2);
//
//
//            while (result1.size() != result2.size()){
//                if (result1.size() > result2.size()){
//                    result1.pop();
//                }
//                if (result1.size() < result2.size()){
//                    result2.pop();
//                }
//            }
//
//
//        while (result1.size() > 0){
//            TreeNode treeNode = result1.pop();
//            if (treeNode == result2.pop()){
//                return treeNode;
//            }
//        }
//        return null;
//    }

//    Stack<TreeNode> result = new Stack<>();
//    public static TreeNode  getAllAncestor(TreeNode root, TreeNode node,Queue<TreeNode> result){
//        if (root != null){
//            if (root.getValue() == node.getValue()){
//                result.offer(root);
//                return null;
//            }
//            if ((root.getLeftChild()!= null && root.getLeftChild().getValue() == node.getValue() )
//                    || (root.getRightChild()!= null && root.getRightChild().getValue() == node.getValue())){
//                result.offer(node);
//                result.offer(root);
//                return root;
//            }
//            TreeNode node1 = getAllAncestor(root.getLeftChild(),node,result);
//            if (node1 != null && root.getLeftChild().getValue() == node1.getValue()){
//                result.offer(root);
//                return root;
//            }
//
//            TreeNode node2 =getAllAncestor(root.getRightChild(),node,result);
//            if (node2 != null && root.getRightChild().getValue() == node2.getValue()){
//                result.offer(root);
//                return root;
//            }
//
//        }
//
//        return null;
//    }

    public static void  getAllAncestor(TreeNode root, TreeNode node,Stack<TreeNode> result){

        TreeNode currentNode = root;
        TreeNode preNode = null;


        while (currentNode != null || !result.isEmpty()) {

            //左子树
            while (currentNode != null) {
                result.push(currentNode);
                if (currentNode.getValue() == node.getValue()){
                    return;
                }
                currentNode = currentNode.getLeftChild();
            }
            TreeNode popNode = result.pop();
            currentNode = popNode.getRightChild();
            //当前节点右子树不为空（1.还未遍历右子树；2.已经遍历过右子树了，通过preNode是否与当前右子树根结点相同来判断）
            if (currentNode != null && preNode != popNode.getRightChild()) {
                result.push(popNode);
            } else {

                //记录打印的值
                preNode = popNode;
                currentNode = null;
            }
        }
    }


    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.getLeftChild(), p, q);
        boolean rson = dfs(root.getRightChild(), p, q);
        //两种情况：1.p,q分别在该节点的左右子树中；2.p,q其中一个节点本身，另一个节点在其子树上
        if ((lson && rson) || ((root.getValue() == p.getValue() || root.getValue() == q.getValue()) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.getValue() == p.getValue() || root.getValue() == q.getValue());
    }

    /**
     * 获取最早公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    /**
     * 验证是否是搜索二叉树（不断缩小边界来判断）
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);

    }

    public static boolean isValidBST(TreeNode root,int maxValue,int minValue) {
        if (root == null) {
            return true;
        }

        if (root.getValue() <= minValue || root.getValue() >= maxValue){
            return false;
        }

        return isValidBST(root.getLeftChild(),maxValue,root.getValue())&&isValidBST(root.getRightChild(),root.getValue(),minValue);
    }


    /**
     * 插入搜索二叉树
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }

        if (val < root.getValue()){
            root.setLeftChild(insertIntoBST(root.getLeftChild(),val));
        }else{
            root.setRightChild(insertIntoBST(root.getRightChild(),val));

        }

        return root;
    }

        public static void main(String[] args) {
        //[[5,1,4,null,null,3,6]]
        TreeNode nodea = new TreeNode(5);
        TreeNode nodeb = new TreeNode(1);
        TreeNode nodec = new TreeNode(4);
        TreeNode noded = new TreeNode(3);
        TreeNode nodee = new TreeNode(6);
//        TreeNode nodef = new TreeNode(0);
//        TreeNode nodeg = new TreeNode(8);
//        TreeNode nodeh = new TreeNode(7);
//        TreeNode nodei = new TreeNode(4);
        //TreeNode node3 = new TreeNode(3);

        nodea.setLeftChild(nodeb);
        nodea.setRightChild(nodec);
        nodeb.setLeftChild(noded);
        nodeb.setRightChild(nodee);
        nodec.setLeftChild(noded);
        nodec.setRightChild(nodee);
//        nodee.setLeftChild(nodeh);
//        nodee.setRightChild(nodei);

        TreeNode node5 = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        node5.setRightChild(node1);
        System.out.println(isValidBST(nodea));
//        TreeNode result = lowestCommonAncestor(nodea,node1,node5);
//        Stack<TreeNode> result1 = new Stack<>();
//        getAllAncestor(nodea,node5,result1);
//        System.out.println(result.getValue());
//        int a = 1;
//        int b = 1;
//        if (a == 1){
//            System.out.println("aaaaaaaa");
//        }else if (b == 1){
//            System.out.println("bbbbbbbb");
//        }else {
//            System.out.println("ccccccccc");
//        }
//        System.out.println(maxPathSum(nodea));
//        node1.setRightChild(node2);
//        node2.setLeftChild(node3);
//        node2.setRightChild(node4);
//        postorderTraversal(node1);

        //[0,2,4,1,null,3,-1,5,1,null,6,null,8]
//        BinaryTree tree = new BinaryTree(node0);
//        System.out.println(tree.hight());

    }



}
