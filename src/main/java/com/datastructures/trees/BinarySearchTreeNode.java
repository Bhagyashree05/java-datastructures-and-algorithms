package com.datastructures.trees;

public class BinarySearchTreeNode {

  private int value;
  private BinarySearchTreeNode left;
  private BinarySearchTreeNode right;

  public BinarySearchTreeNode(int value, BinarySearchTreeNode left, BinarySearchTreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public BinarySearchTreeNode(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public BinarySearchTreeNode getLeft() {
    return left;
  }

  public void setLeft(BinarySearchTreeNode left) {
    this.left = left;
  }

  public BinarySearchTreeNode getRight() {
    return right;
  }

  public void setRight(BinarySearchTreeNode right) {
    this.right = right;
  }
}
