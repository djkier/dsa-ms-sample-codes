package datastructure.ds3_1_5_1;

import datastructure.ds3_1.InventoryItem;

public class BinarySearchTree {
    private NodeBST root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insertItem(InventoryItem newItem) {

        NodeBST newNode = new NodeBST(newItem);

        //Case 1 : Tree is empty
        if (root == null) {
            root = newNode;
            return;
        }

        NodeBST current = root;

        while (true) {

            //Lexicographical comparison
            //returns -1 if the new data should go before the current data
            //returns 1 if the new data should go after
            //returns 0 if they have same value
            int comparison = newItem.getEngineNumber().compareTo(current.getData().getEngineNumber());

            if (comparison < 0) {

                //Go to left subtree
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    return;
                } else {
                    current = current.getLeft();
                }

            } else if (comparison > 0) {

                //Go to right subtree
                if(current.getRight() == null) {
                    current.setRight(newNode);
                    return;
                } else {
                    current = current.getRight();
                }

            } else {
                //Duplicate engine number
                System.out.println("Duplicate engine number. Should not be existed. Insertion skipped");
                return;
            }

        }
    }

}
