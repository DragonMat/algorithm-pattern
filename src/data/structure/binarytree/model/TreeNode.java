package data.structure.binarytree.model;


/**
 * 二叉树的节点数据结构
 */
public class TreeNode {

    //值
    private  int value;

    //左孩子
    private TreeNode leftChild;

    //右孩子
    private TreeNode rightChild;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode(int value) {
        this.value = value;
    }
}
