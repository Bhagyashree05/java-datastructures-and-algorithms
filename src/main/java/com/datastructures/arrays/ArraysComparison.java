package com.datastructures.arrays;

import java.util.HashMap;

/*Given 2 arrays, create a function that let's a user know (true/false)
whether these two arrays contain any common items*/
public class ArraysComparison {

  public static void main(String[] args) {
    char[] array1 = {'a', 'c', 'x', 'j'};
    char[] array2 = {'y', 'l', 'x'};
    ArraysComparison compObj = new ArraysComparison();
    boolean compFlag = compObj.comparisonWorstCaseFunction(array1, array2);
    System.out.println("comparisonWorstCaseFunction() result : " + compFlag);
    compFlag = compObj.comparisonFunction(array1, array2);
    System.out.println("comparisonFunction() result : " + compFlag);
  }

  // nested for loop Time Complexity O(n^2)
  // Even if two arrays are of different size a and b => O(a*b)
  // Space complexity O(1) -> data structures are not created
  private boolean comparisonWorstCaseFunction(char[] array1, char[] array2) {
    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; j++) {
        if (array1[i] == array2[j]) {
          return true;
        }
      }
    }
    return false;
  }

  // Time Complexity => O(n)
  // Space Complexity => O(a) let a be size of the array 1. We are creating new data structure.
  private boolean comparisonFunction(char[] array1, char[] array2) {
    HashMap map = new HashMap();
    for (int i = 0; i < array1.length; i++) { // O(n)
      map.put(array1[i], true);
    }
    for (int j = 0; j < array2.length; j++) { // O(n)
      if (!map.isEmpty() && map.containsKey(array2[j])) {
        return true;
      }
    }
    return false;
  }
}
