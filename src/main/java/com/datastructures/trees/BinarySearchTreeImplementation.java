package com.datastructures.trees;

public class BinarySearchTreeImplementation {
  private BinarySearchTreeNode root;

  public BinarySearchTreeImplementation() {
    root = null;
  }

  public static void main(String[] args) {
    BinarySearchTreeImplementation obj = new BinarySearchTreeImplementation();
    //			  50
    //		40			70
    //	30		45	60		85
    obj.insert(50);
    obj.insert(40);
    obj.insert(70);
    obj.insert(30);
    obj.insert(45);
    obj.insert(60);
    obj.insert(85);
    BinarySearchTreeNode result = obj.lookup(50);
    System.out.println(result.getValue());
    System.out.println(result.getLeft().getValue());
    System.out.println(result.getRight().getValue());
  }

  private void insert(int value) {
    BinarySearchTreeNode newNode = new BinarySearchTreeNode(value);

    // if tree is empty, assign value to root node
    if (this.root == null) {
      this.root = newNode;
    } else {
      BinarySearchTreeNode currentNode = this.root;
      while (true) {
        // insert element at the right side of the tree
        if (currentNode.getValue() < value) {
          if (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
          } else {
            currentNode.setRight(newNode);
            break;
          }
        } else {
          if (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
          } else {
            currentNode.setLeft(newNode);
            break;
          }
        }
      }
    }
  }

  private BinarySearchTreeNode lookup(int value) {
    if (this.root == null) {
      return null;
    }
    BinarySearchTreeNode currentNode = this.root;
    while (currentNode != null) {
      if (value < currentNode.getValue()) {
        currentNode = currentNode.getLeft();
      } else if (value > currentNode.getValue()) {
        currentNode = currentNode.getRight();
      } else {
        return currentNode;
      }
    }
    return null;
  }

  private void remove(int value) {
    if (this.root == null) {
      return;
    }
    BinarySearchTreeNode currentNode = this.root;
    BinarySearchTreeNode parentNode = null;
    while (currentNode != null) {
      if (value < currentNode.getValue()) {
        parentNode = currentNode;
        currentNode = currentNode.getLeft();
      } else if (value > currentNode.getValue()) {
        parentNode = currentNode;
        currentNode = currentNode.getRight();
      } else if (currentNode.getValue() == value) {

        // Option 1: No right child
        if (currentNode.getRight() == null) {
          if (parentNode == null) {
            this.root = currentNode.getLeft();
          } else {
            // if parentNode >  currentNode.getValue() , make currentNode left child a child of
            // parentNode
            if (currentNode.getValue() < parentNode.getValue()) {
              parentNode.setLeft(currentNode.getLeft());
            }
            // if parentNode <  currentNode.getValue() , make currentNode left child a right child
            // of parentNode
            else if (currentNode.getValue() > parentNode.getValue()) {
              parentNode.setRight(currentNode.getLeft());
            }
          }
        }

        // Option 2: Right child which doesn't have a left child
        else if (currentNode.getRight().getLeft() == null) {
          if (parentNode == null) {
            this.root = currentNode.getLeft();
          } else {
            // if parentNode >  currentNode.getValue() , make currentNode right child a child of
            // parentNode
            if (currentNode.getValue() < parentNode.getValue()) {
              parentNode.setLeft(currentNode.getRight());
            }
            // if parentNode <  currentNode.getValue() , make currentNode right child a right child
            // of parentNode
            else if (currentNode.getValue() > parentNode.getValue()) {
              parentNode.setRight(currentNode.getRight());
            }
          }
        }

        // Option 3: Right child that has a left child
        else {

          // find the Right Child's left most child
          BinarySearchTreeNode leftNode = currentNode.getRight().getLeft();
          BinarySearchTreeNode leftNodeParent = currentNode.getRight();
          while (leftNode.getLeft() != null) {
            leftNodeParent = leftNode;
            leftNode = leftNode.getLeft();
          }

          // Parent's left subtree is now leftNode's right subtree
          leftNodeParent.setLeft(leftNode.getRight());
          leftNode.setLeft(currentNode.getLeft());
          leftNode.setRight(currentNode.getRight());

          if (parentNode == null) {
            this.root = leftNode;
          } else {
            if (currentNode.getValue() < parentNode.getValue()) {
              parentNode.setLeft(leftNode);
            } else if (currentNode.getValue() > parentNode.getValue()) {
              parentNode.setRight(leftNode);
            }
          }
        }
      }
    }
  }
}
