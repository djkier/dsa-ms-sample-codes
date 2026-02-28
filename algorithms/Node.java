package algorithms;

import algorithms.InventoryItem;

public class Node {
    private InventoryItem data;
    private Node next;
    private Node prev;

    public Node(InventoryItem data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public void setPrev(Node prevNode) {
        this.prev = prevNode;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public InventoryItem getData() {
        return this.data;
    }

}
