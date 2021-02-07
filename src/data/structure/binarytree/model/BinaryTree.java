package data.structure.binarytree.model;

import java.util.*;

public class BinaryTree {

    //根结点
    private TreeNode root=null;

    public BinaryTree(){}

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /**
     *  清除子树
     */
    public void clear(TreeNode node){
        if (node !=null){
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;//清除节点
        }
    }

    /**
     *  清除根结点
     */
    public void clear(){
        clear(root);
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * (递归)获取以某节点的树高（DFS)
     * @param node
     * @return
     */
    public int hightRecursion(TreeNode node){

        if (node == null){
            return 0;//当前节点为null则树高为0
        }else{
            int l = hightRecursion(node.getLeftChild());//递归获取左子树的树高
            int r = hightRecursion(node.getRightChild());//递归获取右子树的树高
            return l > r? (l+1) : (r+1);//左右子树高的为树高+自身这一层
        }

    }

    /**
     * (非递归)获取以某节点的树高（BFS）
     * @param node
     * @return
     */
    public int hight(TreeNode node){

        if (node == null){
            return 0;//当前节点为null则树高为0
        }
        int treeHight = 0;

        Queue<TreeNode> tempNode = new LinkedList<>();
        tempNode.offer(node);
        while (!tempNode.isEmpty()){
            int count = tempNode.size();
            while (count > 0){
                node = tempNode.poll();
                if (node.getLeftChild() != null){
                    tempNode.offer(node.getLeftChild());
                }
                if (node.getRightChild() != null){
                    tempNode.offer(node.getRightChild());
                }
                count--;
            }
            treeHight++;

        }

        Stack<List<Integer>> tempResult = new Stack<>();



        return treeHight;

    }

    /**
     * 获取树高
     * @return
     */
    public int hight(){
        return hight(root);
    }


    /**
     * 获取某子数的节点数
     * @param node
     * @return
     */
    public int size(TreeNode node){
        if (node == null){
            return 0;//当前节点为null则节点数为0
        }else{
            //当前节点+左子树节点数+右子树节点数
            return 1 + size(node.getLeftChild())+size(node.getRightChild());
        }
    }

    /**
     * 当前树的节点数
     * @return
     */
    public int size(){
        return size(root);
    }

    /**
     * 寻找某节点在某子树中的父亲节点（还可以在node中增加parent字段来解决）
     * @param subTree
     * @param node
     * @return
     */
    public TreeNode getParent(TreeNode subTree, TreeNode node){
        if (subTree == null){
            return null;//子树为null
        }

        if (subTree.getLeftChild() == node || subTree.getRightChild() == node){
            return subTree;
        }
        TreeNode parent;
        parent = getParent(subTree.getLeftChild(),node);//从左子树中找寻

        if (parent != null){
            return  parent;
        }
        parent = getParent(subTree.getRightChild(), node);//从右子树找寻

        return parent;
    }

    /**
     * 从树中找节点的父节点
     * @param node
     * @return
     */
    public TreeNode getParent(TreeNode node){
        return getParent(root,node);
    }

    /**
     * 是否是平衡二叉树
     * @param node
     * @return
     */
    public  boolean isBalanced(TreeNode node){

        int hight = higthForBalance(root);
        if ( hight >= 0){
            return true;
        }
        return false;

    }

    /**
     * 自底向上判断，如果存在而左右子树树高相差大于1的则是不平衡，最后输出-1；如果是平衡的，则是正常树高>=0
     * @param node
     * @return
     */
    private int higthForBalance(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftHight = higthForBalance(node.getLeftChild());
        int rightHight = higthForBalance(node.getRightChild());

        if (leftHight == -1 || rightHight == -1 || Math.abs(leftHight-rightHight) >1){
            return -1;
        }else {
            return leftHight > rightHight ?(leftHight+1) : (rightHight+1);
        }

    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }



}
