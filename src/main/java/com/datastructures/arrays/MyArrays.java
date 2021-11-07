package com.datastructures.arrays;

import java.util.Arrays;

// Program to create an Array
public class MyArrays {

  private Object[] data;
  private int capacity;
  private int length;

  MyArrays() {
    capacity = 1;
    length = 0;
    data = new Object[1];
  }

  public static void main(String[] args) {
    MyArrays myArraysObj = new MyArrays();
    myArraysObj.push(10);
    myArraysObj.push(5);
    myArraysObj.push(20);
    myArraysObj.push(25);
    System.out.println("get() method demo : " + myArraysObj.get(1));
    myArraysObj.pop();
    System.out.println("Array after pop() :");
    myArraysObj.printArray();
    myArraysObj.delete(0);
    System.out.println("\nArray after delete() :");
    myArraysObj.printArray();
  }

  // method to return element at the given index of the array
  private Object get(int index) {
    return data[index];
  }

  // method to add elements at the end of the array
  private void push(Object obj) {
    // if length of the array is equal to capacity, we need to increase the capacity to add more
    // elements.
    if (capacity == length) {
      // create a new array with double capacity and copy old array elements to new array
      data = Arrays.copyOf(data, capacity * 2);
      capacity *= 2;
    }
    data[length] = obj;
    length++;
  }

  // method to delete element which is at the end of the array
  private void pop() {
    data[length - 1] = null;
    length--;
  }

  // method to delete elements which is at the given index of the array
  private void delete(int index) {
    if (index > -1 && index <= length) {
      if (index == length - 1) {
        pop();
      } else {
        shiftItems(index);
      }
    } else {
      System.out.println("Index Out Of Bound Exception");
    }
  }

  // method to shift elements in an array
  private void shiftItems(int index) {
    for (int i = index; i < length - 1; i++) {
      data[i] = data[i + 1];
    }
    data[length - 1] = null;
    length--;
  }

  // method to print array
  private void printArray() {
    for (int i = 0; i < data.length - 1; i++) {
      System.out.print(data[i] + "\t");
    }
  }
}
