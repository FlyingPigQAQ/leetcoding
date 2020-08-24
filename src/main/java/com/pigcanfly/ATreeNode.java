package com.pigcanfly;

/**
 * @author tobbyquinn
 * @date 2020/05/21
 */
public abstract class ATreeNode {
    private int val;
    private ATreeNode left;
    private ATreeNode right;

    public ATreeNode() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ATreeNode getLeft() {
        return left;
    }

    public void setLeft(ATreeNode left) {
        this.left = left;
    }

    public ATreeNode getRight() {
        return right;
    }

    public void setRight(ATreeNode right) {
        this.right = right;
    }
}
