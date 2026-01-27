package algorithms.custom;

import algorithms.InventoryItem;
import algorithms.Node;

public class Inventory {
    private Node head;
    private Node tail;

    public Inventory() {
        this.head = null;
        this.tail = null;
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.println(current.getData().getEngineNumber());

            current = current.getNext();
        }
    }

    public void addNewStock(InventoryItem newItem) {
        //Create a new node
        Node newNode = new Node(newItem);

        if (head == null) {
        //If there is no node, set the newNode to head and tail
            head = newNode;
            tail = newNode;
        } else {
        //If there is a node, set the current tail next to the newNode
            tail.setNext(newNode);
            //Then change the tail to the newNode
            tail = newNode;
        }
    }

    public void deleteStock(String targetEngineNum) {
        //Use head as the starting point of transversal
        Node current = head;
        Node previous = null;

        // Traverse the linked list from head to tail until the target is found
        while (current != null) {
            if (current.getData().getEngineNumber().equalsIgnoreCase(targetEngineNum)) {
                //Case 1: If the target is the head
                if (previous == null) {
                    //The next of the head will be the new head
                    head = current.getNext();
                    //If list becomes empty, update tail
                    if (head == null) {
                        tail = null;
                    }

                }
                //Case 2: the target is on the middle or tail
                else {
                    //Change the previous next to the current next
                    previous.setNext(current.getNext());
                    //If the target is tail, then the previous node will be the new tail
                    if (current == tail) {
                        tail = previous;
                    }
                }
                //Exit after successful deletion
                return;
            }

            //If the current is not the target, move to the next node
            previous = current;
            current = current.getNext();
        }
    }

    public Inventory sortByBrand() {
        //Create new Inventory where the node will be sorted
        Inventory sortedInventory = new Inventory();
        Node current = head;

        //Traverse the custom linked list
        while (current != null) {
            //Get the current item
            InventoryItem item = current.getData();
            Node newNode = new Node(item);

            // Case 1: New list is empty or new item comes before the new head
            if (sortedInventory.head == null ||
                    //Check if the brand is same with the head or it should go first before the head
                    sortedInventory.head.getData().getBrand()
                            .compareToIgnoreCase(item.getBrand()) >= 0) {
                //Change the sortedInventory head with the newNode
                newNode.setNext(sortedInventory.head);
                sortedInventory.head = newNode;
            }
            // Case 2: Traverse the sorted list to find the correct insertion point
            else {
                //Start the search from the sortedInventory head
                Node search = sortedInventory.head;
                //Search the sortedInventory until the next node is not null
                while (search.getNext() != null &&
                        //And until the "search" node should go first before the newNode
                        search.getNext().getData().getBrand()
                                .compareToIgnoreCase(item.getBrand()) < 0) {
                    //Continue searching
                    search = search.getNext();
                }
                //Set the newNode next to the "search" node next
                newNode.setNext(search.getNext());
                //Set the "search" node next to the newNode
                search.setNext(newNode);
            }

            //Continue until sorted
            current = current.getNext();
        }

        return sortedInventory;
    }

    public InventoryItem searchInventory(String criteriaField, String searchValue) {
        Node current = head;
        //Simplify criteria field case
        String field = criteriaField.toLowerCase();

        //Traverse the nodes until criteria met or until there is no node
        while (current != null) {
            InventoryItem item = current.getData();

            if (field.equals("date") &&
                    item.getDateEntered().toString().equals(searchValue)) {
                return item;

            } else if (field.equals("stock label") &&
                    item.getStockLabel().toString().equalsIgnoreCase(searchValue)) {
                return item;

            } else if (field.equals("brand") &&
                    item.getBrand().equalsIgnoreCase(searchValue)) {
                return item;

            } else if (field.equals("engine number") &&
                    item.getEngineNumber().equalsIgnoreCase(searchValue)) {
                return item;

            } else if (field.equals("status") &&
                    item.getStatus().toString().equalsIgnoreCase(searchValue)) {
                return item;
            }

            //Check the next node
            current = current.getNext();
        }

        //Return nothing if match not found
        return null;
    }

}
