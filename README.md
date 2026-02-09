# CS146 Homework 2 – Lomuto and Hoare Partition

In this homework, I implemented two partition schemes used in QuickSort:

- Lomuto partition
- Hoare partition

Both implementations are written in Java and tested using JUnit.

## Description

The Lomuto partition scheme selects the last element as the pivot and rearranges the array so that elements less than or equal to the pivot appear before it, and larger elements appear after it.

The Hoare partition scheme uses two pointers moving toward each other from both ends of the array and swaps elements that are on the wrong side of the pivot.

## Unit Tests

The unit tests were written based on the arrays specified in the assignment:

- Sorted array:
10 17 19 21 44 55 57 63 65 67

- Empty array:
{}

- Unsorted array:
84 3 7 1 9 6 2 5

The tests will verify that the partitioning is performed correctly for both partition methods.

## How to Run

From the `hw2` directory, run:
mvn test

All tests will pass with `BUILD SUCCESS`.
