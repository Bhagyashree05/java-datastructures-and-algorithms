package com.algorithms.recursion;

// Given a number N return the index value of the fibonacci sequence
// The pattern of the sequence is that each value is the sum of the two previous values
// 0, 1, 1, 2, 3, 5, 8, 13, 21, .....
public class FibonacciSeries {

  public static void main(String[] args) {
    FibonacciSeries fibonacciObj = new FibonacciSeries();
    System.out.println(
        "Fibonacci Series result using findFibonacciUsingIteration() method : "
            + fibonacciObj.findFibonacciUsingIteration(8));
    System.out.println(
        "Fibonacci Series result using findFibonacciUsingRecursion() method : "
            + fibonacciObj.findFibonacciUsingRecursion(8));
  }

  // Time Complexity = O(n)
  private int findFibonacciUsingIteration(int n) {
    if (n == 0) {
      return 0;
    }
    int firstNumber = 0;
    int secondNumber = 1;
    int temp;
    for (int i = 2; i <= n; i++) {
      temp = secondNumber;
      secondNumber += firstNumber; // secondNumber+firstNumber
      firstNumber = temp;
    }
    return secondNumber;
  }

  // Time Complexity = O(2^n) => Exponential time
  private int findFibonacciUsingRecursion(int n) {
    if (n < 2) {
      return n;
    }
    return findFibonacciUsingRecursion(n - 1) + findFibonacciUsingRecursion(n - 2);
  }
}
