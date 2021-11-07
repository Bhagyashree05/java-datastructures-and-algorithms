package com.datastructures.linkedlists;

public class DoublyLinkedListImplementation {

  private DoublyLinkedListNode head;
  private DoublyLinkedListNode tail;
  private int length;

  public DoublyLinkedListImplementation(int value) {
    head = new DoublyLinkedListNode(value);
    tail = head;
    length = 1;
  }

  public static void main(String[] args) {
    DoublyLinkedListImplementation DoublyLinkedListObj = new DoublyLinkedListImplementation(5);

    DoublyLinkedListObj.append(7);
    DoublyLinkedListObj.append(10);
    DoublyLinkedListObj.append(12);
    DoublyLinkedListObj.append(15);
    System.out.println("Linked List data after append() : ");
    DoublyLinkedListObj.printData();

    DoublyLinkedListObj.prepend(3);
    System.out.println("\nLinked List data after prepend() : ");
    DoublyLinkedListObj.printData();

    DoublyLinkedListObj.insert(3, 17);
    System.out.println("\nLinked List data after insert() : ");
    DoublyLinkedListObj.printData();

    DoublyLinkedListObj.remove(2);
    System.out.println("\nLinked List data after remove() : ");
    DoublyLinkedListObj.printData();
  }

  // Adding elements at the beginning of the linked list
  public void prepend(int value) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(value, null, head);
    head.setPrevious(newNode);
    head = newNode;
    length++;
  }

  // Adding elements at the end of the linked list
  public void append(int value) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(value, tail, null);
    tail.setNext(newNode);
    tail = newNode;
    length++;
  }

  public void insert(int index, int value) {
    if (index < 0 || index > length) {
      System.out.println("Index Out Of Bound Exception");
      return;
    } else if (index == 0) {
      prepend(value);
      return;
    } else if (index == length) {
      append(value);
      return;
    }

    DoublyLinkedListNode previousNode = traverseToIndex(index - 1);
    DoublyLinkedListNode nextNode = previousNode.getNext();

    DoublyLinkedListNode newNode = new DoublyLinkedListNode(value, previousNode, nextNode);
    previousNode.setNext(newNode);
    nextNode.setPrevious(newNode);
    length++;
  }

  public DoublyLinkedListNode traverseToIndex(int index) {
    DoublyLinkedListNode currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  public void remove(int index) {
    if (index == 0) {
      length--;
      return;
    }
    DoublyLinkedListNode previousNode = traverseToIndex(index - 1);
    DoublyLinkedListNode nodeToBeRemoved = previousNode.getNext();
    previousNode.setNext(nodeToBeRemoved.getNext());
    nodeToBeRemoved.getNext().setPrevious(previousNode);
    length--;
  }

  public void printData() {
    DoublyLinkedListNode currentNode = head;
    if (head == null) {
      return;
    }
    int i = 0;
    while (currentNode != null) {
      System.out.print(currentNode.getValue() + "\t");
      currentNode = currentNode.getNext();
      i++;
    }
  }
}
