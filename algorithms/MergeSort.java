package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private List<InventoryItem> sortedItems;

    public List<InventoryItem> sortByBrandView(Node originalHead) {
        sortedItems = new ArrayList<>();

        //if list is empty
        if (originalHead == null) {
            return sortedItems;
        }

        //make a copy to prevent the order of the original list
        Node copyHead = copyList(originalHead);
        //merge sort algo
        Node sortedHead = mergeSortByBrand(copyHead);

        //convert sorted linked list to an array
        Node current = sortedHead;
        while (current != null) {
            sortedItems.add(current.getData());
            current = current.getNext();
        }

        return sortedItems;
    }

    //copy of the linked list
    private Node copyList(Node start) {

        Node newHead = null;
        Node newTail = null;
        Node current = start;

        while (current != null) {

            //Copy InventoryItem reference
            Node newNode = new Node(current.getData());

            newNode.setNext(null);
            newNode.setPrev(null);

            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.setNext(newNode);
                newNode.setPrev(newTail);
                newTail = newNode;
            }

            current = current.getNext();
        }

        return newHead;
    }

    //recursive merge sort by brand
    private Node mergeSortByBrand(Node headNode) {
        //empty or single node
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }

        //split into 2 halves
        Node secondHalf = splitList(headNode);

        //recursive sorting
        Node leftSorted = mergeSortByBrand(headNode);
        Node rightSorted = mergeSortByBrand(secondHalf);

        //Merge sorted halves
        return mergeByBrand(leftSorted, rightSorted);
    }

    private Node splitList(Node headNode) {
        Node slow = headNode;
        Node fast = headNode;

        while (fast.getNext() != null &&
                fast.getNext().getNext() != null) {

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node secondHalf = slow.getNext();
        slow.setNext(null);

        if (secondHalf != null) {
            secondHalf.setPrev(null);
        }

        return secondHalf;
    }

    private Node mergeByBrand(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        int brandComparison = a.getData().getBrand().
                                compareToIgnoreCase(b.getData().getBrand());

        if (brandComparison < 0 ) {
            result = a;
            result.setNext(mergeByBrand(a.getNext(), b));
        } else if (brandComparison > 0) {
            result = b;
            result.setNext(mergeByBrand(a, b.getNext()));
        } else {
            //if same brand try comparing the date.
            //if same date put at the end of that brand
            if (a.getData().getDateEntered()
                    .compareTo(b.getData().getDateEntered()) <= 0) {
                result = a;
                result.setNext(mergeByBrand(a.getNext(), b));
            } else {
                result = b;
                result.setNext(mergeByBrand(a, b.getNext()));
            }
        }

        if (result.getNext() != null) {
            result.getNext().setPrev(result);
        }

        result.setPrev(null);

        return result;
    }

}
