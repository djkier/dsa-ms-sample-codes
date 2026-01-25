package datastructure.ds3_1_3;

import datastructure.ds3_1.InventoryItem;
import datastructure.ds3_1_2.Node;

public class StacksCustom {
    private Node top;

    // constructor initializes an empty stack
    public StacksCustom() {
        this.top = null;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Add item on the top
    public void push(InventoryItem item) {
        Node newNode = new Node(item);
        newNode.setNext(top);
        top = newNode;
    }

    // Remove the top item
    public InventoryItem pop() {
        if (this.isEmpty()) {
            return null;
        }
        InventoryItem poppedItem = top.getData();
        top = top.getNext();
        return poppedItem;
    }

    // Peek at the top item without removing
    public InventoryItem peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }
}
