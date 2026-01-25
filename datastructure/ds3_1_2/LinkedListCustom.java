package datastructure.ds3_1_2;

import datastructure.ds3_1.InventoryItem;

public class LinkedListCustom {
    private Node head;

    public LinkedListCustom() {
        this.head = null;
    }

    public void add(InventoryItem item) {
        Node newNode = new Node(item);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            //Find the last node
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
}
