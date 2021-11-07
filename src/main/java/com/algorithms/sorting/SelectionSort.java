package com.algorithms.sorting;

// Program to illustrate Selection Sort
// consider one element as smallest, compare and swap. Not used in real time systems.
/*
Time Complexity
Best : O(n^2)
Average : O(n^2)
Worst : O(n^2)
*/
/*
Space Complexity
Worst : O(1)
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] array = {95, 14, 6, 2, 1, 5, 63, 85, 283, 4, 0};
    SelectionSort sortObj = new SelectionSort();
    System.out.print("Sorted Array: \n");
    int[] sortedArray = sortObj.selectionSort(array);
    for (int number : sortedArray) {
      System.out.print(number + "\t");
    }
  }

  private int[] selectionSort(int[] array) {
    int temp = 0;
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
        temp = array[i];
        array[i] = array[min];
        array[min] = temp;
      }
    }
    return array;
  }
}
