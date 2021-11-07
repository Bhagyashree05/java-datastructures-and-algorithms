package com.datastructures.linkedlists;

public class DoublyLinkedListNode {
  private int value;
  private DoublyLinkedListNode previous;
  private DoublyLinkedListNode next;

  public DoublyLinkedListNode(int value) {
    this.value = value;
    this.next = null;
  }

  public DoublyLinkedListNode(int value, DoublyLinkedListNode previous, DoublyLinkedListNode next) {
    this.value = value;
    this.previous = previous;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public DoublyLinkedListNode getPrevious() {
    return previous;
  }

  public void setPrevious(DoublyLinkedListNode previous) {
    this.previous = previous;
  }

  public DoublyLinkedListNode getNext() {
    return next;
  }

  public void setNext(DoublyLinkedListNode next) {
    this.next = next;
  }
}
