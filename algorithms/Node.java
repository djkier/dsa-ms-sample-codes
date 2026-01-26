package algorithms;

import datastructure.ds3_1.InventoryItem;

public class Node {
    private InventoryItem data;
    private Node next;

    public Node(InventoryItem data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public Node getNext() {
        return this.next;
    }

    public InventoryItem getData() {
        return this.data;
    }

}
