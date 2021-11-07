package com.algorithms.sorting;

import java.util.Arrays;

// Program to illustrate Quick Sort
// Quick Sort : Divide and Conquer approach, used for large data.
// We choose pivot element , compare then apply divide and conquer approach
// worst case if pivot is smallest or largest
/*
Time Complexity
Best : O(n log(n))
Average : O(n log(n))
Worst : O(n^2)
*/
/*
Space Complexity
Worst : O(n log(n))
 */
public class QuickSort {
  public static Integer[] quickSort(Integer[] array, int left, int right) {
    int pivot;
    int partitionIndex;

    if (left < right) {
      // last element is assigned to pivot variable
      pivot = right;

      // partition the given array and place smaller elements to left of pivot and greater elements
      // to right of pivot.
      partitionIndex = partition(array, pivot, left, right);

      // sort left and right - recursion call
      quickSort(array, left, partitionIndex - 1);
      quickSort(array, partitionIndex + 1, right);
    }
    return array;
  }

  public static int partition(Integer[] array, int pivot, int left, int right) {
    int pivotValue = array[pivot];
    int partitionIndex = left;

    for (int i = left; i < right; i++) {
      if (array[i] < pivotValue) {
        swap(array, i, partitionIndex);
        partitionIndex++;
      }
    }
    swap(array, right, partitionIndex);
    return partitionIndex;
  }

  private static void swap(Integer[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  public static void main(String[] args) {
    Integer[] array = {1, 9, 54, 8, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
    System.out.println(Arrays.asList(quickSort(array, 0, array.length - 1)));
  }
}
