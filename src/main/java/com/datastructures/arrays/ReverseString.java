package com.datastructures.arrays;

import java.util.Scanner;

public class ReverseString {

  public static void main(String[] args) {
    ReverseString reverseStringObj = new ReverseString();
    System.out.print("Enter String : \n");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println("\nDifferent ways to reverse a string :");
    reverseStringObj.reverseStringUsingCharacterArray(str);
    reverseStringObj.reverseStringUsingStringBuffer(str);
  }

  private void reverseStringUsingCharacterArray(String str) {
    System.out.println("\nReverse String Type 1:");
    char[] s = str.toCharArray();
    for (int i = s.length - 1; i >= 0; i--) {
      System.out.print(s[i]);
    }
  }

  private void reverseStringUsingStringBuffer(String str) {
    System.out.println("\nReverse String Type 2:");
    StringBuffer s = new StringBuffer(str);
    s.reverse();
    System.out.println(s);
  }
}
