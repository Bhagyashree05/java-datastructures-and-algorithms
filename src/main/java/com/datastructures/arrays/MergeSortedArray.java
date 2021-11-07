package com.datastructures.arrays;

import java.util.Arrays;

// Program to merge two sorted arrays
// array1= {3,5,9,31} and array2= {4,7,11}
// mergedArray = {3,4,5,7,9,11,31}
public class MergeSortedArray {

  public static void main(String[] args) {
    MergeSortedArray obj = new MergeSortedArray();
    int[] array1 = {3, 5, 9, 31};
    int[] array2 = {4, 7, 11};
    obj.mergeArray(array1, array2);
  }

  private void mergeArray(int[] array1, int[] array2) {
    if (array1.length > 0 || array2.length > 0) {
      int[] mergedArray = new int[array1.length + array2.length];
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < array1.length && j < array2.length) {
        if (array1[i] < array2[j]) {
          mergedArray[k] = array1[i];
          i++;
        } else {
          mergedArray[k] = array2[j];
          j++;
        }
        k++;
      }

      // If array1.length > array2.length, there are chances elements will be missed, so adding it
      // separately
      while (i < array1.length) {
        mergedArray[k] = array1[i];
        i++;
        k++;
      }

      // If array2.length > array1.length, there are chances elements will be missed, so adding it
      // separately
      while (j < array2.length) {
        mergedArray[k] = array2[j];
        j++;
        k++;
      }
      System.out.println(Arrays.toString(mergedArray));
    }
  }
}
