package data.structure.binarytree.model;

public class LinkList {

    LinkNode head;

    /**
     * 添加节点
     * @param value
     */
    public void addNode(int value){
        LinkNode node = new LinkNode(value);
        if (head == null){
            head = node;
        }else {
            LinkNode currentNode = head;
            while (currentNode.next !=null){
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }
}
