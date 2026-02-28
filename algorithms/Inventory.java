package algorithms;

import datastructure.ds3_1.Status;
import datastructure.ds3_1.StockLabel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

    private Node head;
    private Node tail;
    //Hash table index for fast lookup
    private HashMap<String, Node> engineIndex;

    public Inventory() {
        this.head = null;
        this.tail = null;
        this.engineIndex = new HashMap<>();
    }

    //Add new stock
    public void addNewStock(InventoryItem item) {
        if (item == null) {
            System.out.println("Error: Cannot add null item.");
            return;
        }

        if (engineIndex.containsKey(item.getEngineNumber())) {
            System.out.println("Error: Engine number already exists.");
            return;
        }

        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }

        //update the hash table
        engineIndex.put(item.getEngineNumber(), newNode);
    }

    //Insert stock
    public void insertStockByDate(InventoryItem item) {
        if (item == null) {
            System.out.println("Error: Cannot add null item.");
            return;
        }

        if (engineIndex.containsKey(item.getEngineNumber())) {
            System.out.println("Error: Engine number already exists.");
            return;
        }

        Node newNode = new Node(item);

        // if inventory is empty
        if (head == null) {
            head = newNode;
            tail = newNode;

            engineIndex.put(item.getEngineNumber(), newNode);
            return;
        }

        Node current = head;
        // find correct position by dateEntered
        // move forward while current.dateEntered <= newItem.dateEntered
        while (current != null &&
                (current.getData().getDateEntered().isBefore(item.getDateEntered()) ||
                current.getData().getDateEntered().isEqual(item.getDateEntered()))) {
            current = current.getNext();
        }

        //insert at tail
        if (current == null) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        //insert at head
        else if (current == head) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        //Insert in the middle
        else {
            Node previousNode = current.getPrev();
            newNode.setNext(current);
            newNode.setPrev(previousNode);

            previousNode.setNext(newNode);
            current.setPrev(newNode);
        }

        //update hash table
        engineIndex.put(item.getEngineNumber(), newNode);
    }

    //Delete stock using the hashtable
    public boolean deleteStock(String engineNumber) {
        //basic validation
        if (engineNumber == null || engineNumber.isBlank()) {
            System.out.println("Error: Invalid engine number.");
            return false;
        }

        Node nodeToDelete = engineIndex.get(engineNumber);

        //check if engineNumber does exist
        if (nodeToDelete == null) {
            System.out.println("Error: Stock not found.");
            return false;
        }

        //Only one node in the list
        if (head == nodeToDelete && tail == nodeToDelete) {
            head = null;
            tail = null;
        }
        //node is at the head
        else if (nodeToDelete == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        }
        //node is at the tail
        else if (nodeToDelete == tail) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
        }

        //node is in the middle
        else {
            Node prevNode = nodeToDelete.getPrev();
            Node nextNode = nodeToDelete.getNext();

            if (prevNode != null) prevNode.setNext(nextNode);
            if (nextNode != null) nextNode.setPrev(prevNode);
        }

        //remove from the hash table
        engineIndex.remove(engineNumber);

        //cleanup
        nodeToDelete.setNext(null);
        nodeToDelete.setPrev(null);

        return true;
    }

    //sorting
    public List<InventoryItem> sortByBrand() {
        if (head == null) {
            return new ArrayList<>();
        }

        MergeSort sorter = new MergeSort();
        return sorter.sortByBrandView(head);
    }

    //search using engine number
    public InventoryItem searchByEngineNumber(String engineNumber) {
        //basic validation
        if (engineNumber == null || engineNumber.isBlank()) {
            return null;
        }

        //retrieve node from hashmap
        Node nodeFound = engineIndex.get(engineNumber);

        //if engine number does not exists
        if (nodeFound == null) {
            return null;
        }

        return nodeFound.getData();
    }

    //search by different criteria
    public List<InventoryItem> searchByCriteria(
            String brand,
            Status status,
            LocalDate dateEntered,
            StockLabel stockLabel
    ) {
        List<InventoryItem> results = new ArrayList<>();

        Node current = head;

        while (current != null) {

            InventoryItem item = current.getData();
            boolean match = true;

            //Check brand if provided
            if (brand != null && !item.getBrand().equalsIgnoreCase(brand)) {
                match = false;
            }

            if (match && status != null && item.getStatus() != status) {
                match = false;
            }

            if (match && dateEntered != null &&
                    !item.getDateEntered().isEqual(dateEntered)) {
                match = false;
            }

            if (match && stockLabel != null &&
                    item.getStockLabel() != stockLabel) {
                match = false;
            }

            if (match) {
                results.add(item);
            }

            current = current.getNext();
        }

        return results;
    }

    //Simple getters that are not part of the documentation
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int sizeIndex() {
        return engineIndex.size();
    }


}
