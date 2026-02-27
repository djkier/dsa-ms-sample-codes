package datastructure.ds3_1_5_1;

import datastructure.ds3_1.InventoryItem;

public class NodeBST {
    private InventoryItem data;
    private NodeBST left;
    private NodeBST right;

    public NodeBST(InventoryItem data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public InventoryItem getData() {
        return data;
    }

    public void setData(InventoryItem data) {
        this.data = data;
    }

    public NodeBST getLeft() {
        return left;
    }

    public void setLeft(NodeBST left) {
        this.left = left;
    }

    public NodeBST getRight() {
        return right;
    }

    public void setRight(NodeBST right) {
        this.right = right;
    }
}
