package com.datastructures.queues;

import java.util.NoSuchElementException;

// Program to implement Queue using Linked List
// Queue <- First In First Out
public class QueueImplementationUsingLinkedList {

  private QueueNodes first;
  private QueueNodes last;
  private int length;

  public QueueImplementationUsingLinkedList() {
    first = null;
    last = null;
    length = 0;
  }

  public static void main(String[] args) {
    QueueImplementationUsingLinkedList queueObj = new QueueImplementationUsingLinkedList();
    queueObj.enqueue(5);
    queueObj.enqueue(10);
    queueObj.enqueue(15);
    queueObj.enqueue(20);
    System.out.println("Result after invoking enqueue() : ");
    queueObj.printQueueData();
    System.out.println("\nResult after invoking peek() : ");
    System.out.println(queueObj.peek());
    System.out.println("Result after invoking dequeue() : ");
    queueObj.dequeue();
    queueObj.printQueueData();
  }

  private int peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.getValue();
  }

  private void enqueue(int value) {
    QueueNodes newNode = new QueueNodes(value);
    if (length == 0) {
      // if length=0, queue is empty. Add element at the beginning of the queue
      first = newNode;
    } else {
      // if length>0, queue has elements. Queue works on first in first out basis, so add element at
      // the last location
      last.setNext(newNode);
    }
    last = newNode;
    length++;
  }

  private void dequeue() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    // Remove first element and assign to next element in the queue and decrement length value
    first = first.getNext();
    length--;
    if (length == 1) {
      last = null;
    }
  }

  private void printQueueData() {
    QueueNodes currentNode = first;
    while (currentNode != null) {
      System.out.print(currentNode.getValue() + "\t");
      currentNode = currentNode.getNext();
    }
  }
}
