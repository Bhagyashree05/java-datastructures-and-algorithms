package com.datastructures.queues;

import java.util.Stack;

// Stack is Last In First Out - the newest element is pushed to the bottom of the stack
// Queue is First In First Out
// We use 2 stacks to implement queue. The newly arrived, is pushed and popped twice.
public class QueueImplementationUsingStack {

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> tempStack = new Stack<>();
  private int first;

  public static void main(String[] args) {
    QueueImplementationUsingStack queueObj = new QueueImplementationUsingStack();
    System.out.println("Inserting data into queue : enqueue() ");
    queueObj.enqueue(5);
    queueObj.enqueue(10);
    queueObj.enqueue(15);
    System.out.println("\nDeleting data into queue : dequeue() ");
    queueObj.dequeue();
    System.out.println("\nInvoking peek() method :");
    System.out.println(queueObj.peek());
  }

  // Time Complexity = O(n)
  // Space Complexity = O(n). We need additional memory to store the queue elements
  // consider a scenario where both the stacks are empty and you need to insert first element 5
  // output of first while loop => stack = {} and tempStack={5}
  // output of second while loop => stack = {5} and tempStack = {}
  // Now you want to add second element 10
  // output of first while loop => stack = {} and tempStack={5}
  // tempStack.push(10) => tempStack={5,10} [10 is the top most element]
  // output of second while loop => stack = {10,5} and tempStack = {}
  // Same process is repeated for other elements
  private void enqueue(int value) {
    if (stack.isEmpty()) first = value;
    while (!stack.isEmpty()) {
      tempStack.push(stack.pop());
    }
    tempStack.push(value);
    while (!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }
    System.out.println();
    printStackData(stack);
  }

  // Time Complexity = O(1)
  private void dequeue() {
    stack.pop();
    printStackData(stack);
  }

  private int peek() {
    return first;
  }

  private void printStackData(Stack<Integer> stack) {
    for (Integer i : stack) {
      System.out.print(i + "\t");
    }
  }
}
