package datastructure.ds3_1_4;

import datastructure.ds3_1.InventoryItem;
import datastructure.ds3_1_2.Node;

public class QueueCustom {
    private Node front;
    private Node rear;

    public QueueCustom() {
        front = null;
        rear = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add an item to the rear
    public void enqueue(InventoryItem item) {
        Node newNode = new Node(item);
        if (rear != null) {
            rear.setNext(newNode);
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    // Remove an item from the front
    public InventoryItem dequeue() {
        if (isEmpty()) {
            return null;
        }
        InventoryItem dequeuedItem = front.getData();
        front = front.getNext();
        if (front == null) { // if queue becomes empty
            rear = null;
        }
        return dequeuedItem;
    }

    // Peek at the front item without removing
    public InventoryItem peek() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }
}
