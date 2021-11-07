package com.datastructures.stacks;

import java.util.EmptyStackException;

public class StackImplementationUsingLinkedList {

  private int length;
  private StackNode top;

  public StackImplementationUsingLinkedList() {
    this.length = 0;
    this.top = null;
  }

  public static void main(String[] args) {
    StackImplementationUsingLinkedList stackObj = new StackImplementationUsingLinkedList();
    stackObj.push(5);
    System.out.println("Result after invoking peek() : ");
    System.out.println(stackObj.peek());
    System.out.println("Result after invoking push() : ");
    stackObj.push(10);
    stackObj.push(15);
    stackObj.push(20);
    stackObj.push(25);
    stackObj.printStackData();
    System.out.println("Result after invoking pop() : ");
    stackObj.pop();
    stackObj.printStackData();
    System.out.println("Result after invoking peek() : ");
    System.out.println(stackObj.peek());
  }

  private int peek() {
    if (length == 0) {
      throw new EmptyStackException();
    }
    return this.top.getValue();
  }

  private void push(int value) {
    StackNode newNode = new StackNode(value);
    if (length == 0) {
      this.top = newNode;
    } else {
      StackNode temp = this.top;
      this.top = newNode;
      this.top.setNext(temp);
    }
    length++;
  }

  private void pop() {
    if (top == null) {
      return;
    }
    StackNode temp = this.top;
    this.top = this.top.getNext();
    length--;
  }

  private void printStackData() {
    if (top == null) {
      return;
    }
    StackNode curretNode = top;
    while (curretNode != null) {
      System.out.println(curretNode.getValue());
      curretNode = curretNode.getNext();
    }
  }
}
