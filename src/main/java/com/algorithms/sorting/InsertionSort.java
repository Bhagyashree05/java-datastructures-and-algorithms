package com.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Program to illustrate Insertion Sort
// compare and swap. We use this when input is small and has some preorder
/*
Time Complexity
Best : O(n)
Average : O(n^2)
Worst : O(n^2)
*/
/*
Space Complexity
Worst : O(1)
 */
public class InsertionSort {

  public static void main(String[] args) {
    Integer[] array = {95, 14, 6, 2, 1, 5, 63, 85, 283, 4, 0};
    InsertionSort sortObj = new InsertionSort();
    System.out.print("Sorted Array: \n");
    Integer[] sortedArray = sortObj.insertionSort(array);
    for (int number : sortedArray) {
      System.out.print(number + "\t");
    }
  }

  // consider array = {95, 14, 6, 2, 1, 5, 63, 85, 283, 4, 0}
  // Step 1: check if element at position i is less than the element at the 0th position. If true
  // add element at 0th position
  // i=1, 14<95 then insert 14 at 0th position
  // output = {14,95, 14, 6, 2, 1, 5, 63, 85, 283, 4, 0}
  // Delete element at i+1 position to remove duplicates
  // Output of first iteration : output = {14,95, 6, 2, 1, 5, 63, 85, 283, 4, 0}
  // If first condition fails, go to else block to sort number on the left part
  private Integer[] insertionSort(Integer[] array) {
    List<Integer> list = new LinkedList<>(Arrays.asList(array));
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) < list.get(0)) {
        list.add(0, list.get(i));
        list.remove(i + 1);
      } else {
        if (list.get(i) < list.get(i - 1)) {
          for (int j = 1; j < i; j++) {
            if (list.get(i) > list.get(j - 1) && list.get(i) < list.get(j)) {
              list.add(j, list.get(i));
              list.remove(i + 1);
            }
          }
        }
      }
    }
    return list.toArray(new Integer[0]);
  }
}
