package datastructure.ds3_1_5_2;

import datastructure.ds3_1.InventoryItem;

public class NodeAVL {
    private InventoryItem data;
    private NodeAVL left;
    private NodeAVL right;
    private int height;

    public NodeAVL(InventoryItem data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = -1;
    }

    public InventoryItem getData() {
        return data;
    }

    public void setData(InventoryItem data) {
        this.data = data;
    }

    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    public NodeAVL getRight() {
        return right;
    }

    public void setRight(NodeAVL right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
