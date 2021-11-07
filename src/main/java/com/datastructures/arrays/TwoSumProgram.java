package com.datastructures.arrays;

import java.util.HashMap;

// Given an array of integers nums and an integer target, return indices of the two numbers such
// that they add up to target.
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1]
public class TwoSumProgram {

  public static void main(String[] args) {
    TwoSumProgram obj = new TwoSumProgram();
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = obj.twoSum(nums, target);
    System.out.println("Result : \n");
    for (int indices : result) {
      System.out.print(indices + "\t");
    }
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> temp = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (temp.containsKey(target - nums[i])) {
        result[1] = i;
        result[0] = temp.get(target - nums[i]);
      }
      temp.put(nums[i], i);
    }
    return result;
  }
}
