package com.datastructures.hashtables;

import java.util.Hashtable;

// Program to return first recurring character
// Given an array = {2,5,1,2,3,5,1,2,4} => It should return 2
// Given an array = {2,1,1,2,3,5,1,2,4} => It should return 1
// Given an array = {2,3,4,5 } => It should return null
// Given an array = {2,5,5,2,3,5,1,2,4}: return 5 because the pairs are before 2,2
public class FirstRecurringCharacter {

  public static void main(String[] args) {
    Object[] array = {2, 1, 5, 3, 2, 3, 7, 5};
    FirstRecurringCharacter obj = new FirstRecurringCharacter();
    Object data = obj.firstRecurringCharacter(array);
    System.out.println("First Recurring Character using firstRecurringCharacter() : " + data);
    data = obj.firstRecurringCharacterUsingHashTable(array);
    System.out.println(
        "First Recurring Character using firstRecurringCharacterUsingHashTable() : " + data);
  }

  // Naive approach - nested for loop
  // Time Complexity = O(n^2)
  // Space Complexity = O(1) [No new data structure is created]
  private Object firstRecurringCharacter(Object[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] == array[j]) {
          return array[i];
        }
      }
    }
    return null;
  }

  // Time Complexity = O(n)
  // Space Complexity = O(n) => We created a new data structure to store the elements of array.
  // In the worst case scenario where the element is not repeated, hash table stores all the
  // elements.
  private Object firstRecurringCharacterUsingHashTable(Object[] array) {
    Hashtable<Object, Object> hashtable = new Hashtable<>();
    for (int i = 0; i < array.length; i++) {
      if (hashtable.contains(array[i])) {
        return array[i];
      } else {
        hashtable.put(array[i], i);
      }
    }
    return null;
  }
}
