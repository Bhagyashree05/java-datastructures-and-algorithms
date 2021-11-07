package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Program to illustrate Merge Sort
// Merge Sort : Divide and Conquer approach, used for large data
/*
Time Complexity
Best : O(n log(n))
Average : O(n log(n))
Worst : O(n log(n)
*/
/*
Space Complexity
Worst : O(n)
 */
public class MergeSort {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 8, 54, 9, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46);
    MergeSort sortObj = new MergeSort();
    List<Integer> mergedList = sortObj.mergeSort(list);
    System.out.println("Sorted List: ");
    for (Integer number : mergedList) {
      System.out.print(number + "\t");
    }
  }

  private List<Integer> mergeSort(List<Integer> list) {
    if (list.size() == 1) {
      return list;
    }
    // split the array into right and left halves
    List<Integer> leftList = list.subList(0, list.size() / 2);
    List<Integer> rightList = list.subList(list.size() / 2, list.size());

    // recursion call
    return merge(mergeSort(leftList), mergeSort(rightList));
  }

  private List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
    List<Integer> mergedList = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;
    while (leftIndex < leftList.size() && rightIndex < rightList.size()) {
      // compare elements
      if (leftList.get(leftIndex) < rightList.get(rightIndex)) {
        mergedList.add(leftList.get(leftIndex));
        leftIndex++;
      } else {
        mergedList.add(rightList.get(rightIndex));
        rightIndex++;
      }
    }

    // merge remaining elements
    mergedList.addAll(leftList.subList(leftIndex, leftList.size()));
    mergedList.addAll(rightList.subList(rightIndex, rightList.size()));
    return mergedList;
  }
}
