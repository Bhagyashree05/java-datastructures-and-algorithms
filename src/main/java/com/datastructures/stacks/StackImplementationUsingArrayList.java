package com.datastructures.stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackImplementationUsingArrayList {

  ArrayList<Integer> stackArray = new ArrayList<>();

  public static void main(String[] args) {
    StackImplementationUsingArrayList stackObj = new StackImplementationUsingArrayList();
    stackObj.push(5);
    stackObj.push(10);
    stackObj.push(15);
    stackObj.push(20);
    System.out.print("Stack Elements after push():");
    stackObj.printStackData();
    System.out.print("\nStack Peek Element:");
    System.out.print("\n" + stackObj.peek());
    stackObj.pop();
    System.out.print("\nStack Elements after pop():");
    stackObj.printStackData();
  }

  private Integer peek() {
    if (stackArray.isEmpty()) throw new EmptyStackException();
    return stackArray.get(stackArray.size() - 1);
  }

  private void push(int value) {
    stackArray.add(value);
  }

  private void pop() {
    stackArray.remove(stackArray.size() - 1);
  }

  private void printStackData() {
    System.out.println();
    for (Integer i : stackArray) {
      System.out.print(i + "\t");
    }
  }
}
