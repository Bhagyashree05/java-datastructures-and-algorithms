package com.algorithms.sorting;

// Program to illustrate Bubble Sort
// Each iteration we compare elements and use temporary variable to swap, not used in real time
// system as it is not efficient
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
public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {95, 14, 6, 2, 1, 5, 63, 85, 283, 4, 0};
    BubbleSort sortObj = new BubbleSort();
    System.out.print("Sorted Array: \n");
    int[] sortedArray = sortObj.bubbleSort(array);
    for (int number : sortedArray) {
      System.out.print(number + "\t");
    }
  }

  private int[] bubbleSort(int[] array) {
    int temp = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }
}
