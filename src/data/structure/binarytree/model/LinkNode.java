package data.structure.binarytree.model;

public class LinkNode {

    LinkNode next;

    int value;

    public LinkNode(int value) {
        this.value = value;
        this.next = null;
    }

    public LinkNode(int value,LinkNode next) {
        this.value = value;
        this.next = next;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
