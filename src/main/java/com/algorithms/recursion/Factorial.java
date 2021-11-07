package com.algorithms.recursion;

// Program to find factorial of a number
// Factorial of 5 is => 5! = 5*4*3*2*1
// 5!=120
public class Factorial {

  public static void main(String[] args) {
    Factorial factorialObj = new Factorial();
    System.out.println(
        "Factorial result using findFactorialUsingIterative() method : "
            + factorialObj.findFactorialUsingIteration(5));
    System.out.println(
        "Factorial result using findFactorialUsingRecursive() method : "
            + factorialObj.findFactorialUsingRecursion(5));
  }

  // Time Complexity = O(n)
  private int findFactorialUsingIteration(int number) {
    int factorial = 1;
    if (number == 2) {
      return 2;
    }
    for (int i = 2; i <= number; i++) {
      factorial = factorial * i;
    }
    return factorial;
  }

  // Time Complexity = O(n)
  private int findFactorialUsingRecursion(int number) {
    if (number == 2) {
      return 2;
    }
    return number * findFactorialUsingRecursion(number - 1);
  }
}
