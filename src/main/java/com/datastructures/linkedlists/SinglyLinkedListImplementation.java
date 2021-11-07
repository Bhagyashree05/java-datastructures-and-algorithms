package com.datastructures.linkedlists;

/*Program to create Singly Linked List*/
public class SinglyLinkedListImplementation {

  // starting node of the linked list
  private SinglyLinkedListNode head;

  // ending node of the linked list
  private SinglyLinkedListNode tail;

  private int length;

  SinglyLinkedListImplementation(int value) {
    head = new SinglyLinkedListNode(value);
    tail = head;
    length = 1;
  }

  public static void main(String[] args) {
    SinglyLinkedListImplementation singlyLinkedListObj = new SinglyLinkedListImplementation(20);

    singlyLinkedListObj.append(15);
    singlyLinkedListObj.append(25);
    singlyLinkedListObj.append(75);
    singlyLinkedListObj.append(65);
    System.out.println("Linked List data after append() : ");
    singlyLinkedListObj.printData();

    singlyLinkedListObj.prepend(35);
    System.out.println("\nLinked List data after prepend() : ");
    singlyLinkedListObj.printData();

    singlyLinkedListObj.insert(2, 45);
    System.out.println("\nLinked List data after insert() : ");
    singlyLinkedListObj.printData();

    singlyLinkedListObj.remove(1);
    System.out.println("\nLinked List data after remove() : ");
    singlyLinkedListObj.printData();

    System.out.println("\nLinked List data after reverseLinkedList() : ");
    SinglyLinkedListImplementation singlyLinkedListObjForReverse =
        singlyLinkedListObj.reverseLinkedList(singlyLinkedListObj);
    singlyLinkedListObjForReverse.printData();
  }

  // Adding element at the beginning of the linked list
  public void prepend(int value) {
    head = new SinglyLinkedListNode(value, head);
    length++;
  }

  // Adding element at the end of the linked list
  public void append(int value) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
    tail.setNext(newNode);
    tail = newNode;
    length++;
  }

  public void printData() {
    SinglyLinkedListNode currentNode = head;
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

  // Let singlyLinkedListObj = {35,20,15,25}
  // index 0=35, 1=20, 2=15, 3=25
  // Consider you want to insert an element at index=2 and value=40
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

    SinglyLinkedListNode previousNode = traverseToIndex(index - 1); // return index 1 , value 20
    SinglyLinkedListNode nextNode =
        previousNode
            .getNext(); // returns index 2 , value 15 and we want to insert new value at this index

    SinglyLinkedListNode newNode =
        new SinglyLinkedListNode(value, nextNode); // creates new node and points to next node
    previousNode.setNext(
        newNode); // Previously it was pointing to previousNode, now it will point to nextNode
    length++;
  }

  public void remove(int index) {
    if (index == 0) {
      length--;
      return;
    }
    SinglyLinkedListNode previousNode = traverseToIndex(index - 1);
    SinglyLinkedListNode nodeToBeRemoved = previousNode.getNext();
    previousNode.setNext(nodeToBeRemoved.getNext());
    length--;
  }

  public SinglyLinkedListNode traverseToIndex(int index) {
    SinglyLinkedListNode currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  public SinglyLinkedListImplementation reverseLinkedList(
      SinglyLinkedListImplementation singlyLinkedListObj) {
    SinglyLinkedListImplementation newLinkedList =
        new SinglyLinkedListImplementation(singlyLinkedListObj.head.getValue());
    SinglyLinkedListNode current = singlyLinkedListObj.head;
    while (current.getNext() != null) {
      current = current.getNext();
      SinglyLinkedListNode newNode = new SinglyLinkedListNode(current.getValue());
      newNode.setNext(newLinkedList.head);
      newLinkedList.head = newNode;
      newLinkedList.length++;
    }
    return newLinkedList;
  }
}
