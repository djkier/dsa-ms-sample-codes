package datastructure.ds3_1_5_2;

import datastructure.ds3_1.InventoryItem;

public class AVLTree {
    private NodeAVL root;

    public AVLTree() {
        this.root = null;
    }

    private int getHeight(NodeAVL node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(NodeAVL node) {
        if (node == null)  {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private NodeAVL rotateRight(NodeAVL y) {
        NodeAVL x = y.getLeft();
        NodeAVL t2 = x.getRight();

        //rotate
        x.setRight(y);
        y.setLeft(t2);

        //update heights
        y.setHeight(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));
        x.setHeight(1 + Math.max(getHeight(x.getLeft()), getHeight(x.getRight())));

        return x;
    }

    private NodeAVL rotateLeft(NodeAVL x) {
        NodeAVL y = x.getRight();
        NodeAVL t2 = y.getLeft();

        //rotate to right
        y.setLeft(x);
        x.setRight(t2);

        //update heights
        x.setHeight(1 + Math.max(getHeight(x.getLeft()), getHeight(x.getRight())));
        y.setHeight(1 + Math.max(getHeight(y.getLeft()), getHeight(y.getRight())));

        return y;
    }

    //overload
    public void insertItem(InventoryItem newItem) {
        root = insertItem(root, newItem);
    }

    public NodeAVL insertItem(NodeAVL node, InventoryItem newItem) {
        //Step 1: Standard BST insertion
        if (root == null) {
            return new NodeAVL(newItem);
        }

        //compare engine numbers lexicographically
        int comparison = newItem.getEngineNumber().compareTo(node.getData().getEngineNumber());

        if (comparison < 0) {
            node.setLeft(insertItem(node.getLeft(), newItem));
        } else if (comparison > 0) {
            node.setRight(insertItem(node.getRight(), newItem));
        } else {
            //Duplicate engine number
            return node;
        }

        //update height
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));

        //balance factor
        int balance = getBalance(node);

        //Rebalanace if needed
        //case 1 : Left Left
        if (balance > 1 &&
            newItem.getEngineNumber().compareTo(node.getLeft().getData().getEngineNumber()) < 0) {

            return rotateRight(node);
        }

        //case 2 : right right
        if (balance < -1 &&
            newItem.getEngineNumber().compareTo(node.getRight().getData().getEngineNumber()) > 0) {

            return rotateLeft(node);
        }

        //case 3 : left right
        if (balance > 1 &&
            newItem.getEngineNumber().compareTo(node.getRight().getData().getEngineNumber()) > 0) {
            return rotateRight(node);
        }

        //case 4 : right left
        if (balance < -1 &&
            newItem.getEngineNumber().compareTo(node.getLeft().getData().getEngineNumber()) < 0) {
            return rotateLeft(node);
        }

        return node;
    }

    //Check if it is working properly
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(NodeAVL node) {
        if (node == null) return;
        printInOrder(node.getLeft());
        System.out.print(node.getData().getEngineNumber() + " ");
        printInOrder(node.getRight());
    }

}
