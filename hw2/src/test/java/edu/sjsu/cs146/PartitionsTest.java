package edu.sjsu.cs146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionsTest {

    private static boolean isPartitionedLomuto(int[] a, int low, int high, int pivotIndex, int pivotVal) {
        if (a[pivotIndex] != pivotVal) return false;

        for (int k = low; k < pivotIndex; k++) {
            if (a[k] > pivotVal) return false;
        }
        for (int k = pivotIndex + 1; k <= high; k++) {
            if (a[k] <= pivotVal) return false;
        }
        return true;
    }

    private static boolean isPartitionedHoare(int[] a, int low, int high, int j, int pivotVal) {
        for (int k = low; k <= j; k++) {
            if (a[k] > pivotVal) return false;
        }
        for (int k = j + 1; k <= high; k++) {
            if (a[k] < pivotVal) return false;
        }
        return true;
    }

    @Test
    void lomuto_sortedArray() {
        int[] a = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int low = 0, high = a.length - 1;
        int pivotVal = a[high];

        int p = Partitions.lomutoPartition(a, low, high);

        assertTrue(isPartitionedLomuto(a, low, high, p, pivotVal));
    }

    @Test
    void lomuto_emptyArray_throws() {
        int[] a = {};
        assertThrows(IllegalArgumentException.class, () -> Partitions.lomutoPartition(a, 0, 0));
    }

    @Test
    void lomuto_randomArray() {
        int[] a = {84, 3, 7, 1, 9, 6, 2, 5};
        int low = 0, high = a.length - 1;
        int pivotVal = a[high];

        int p = Partitions.lomutoPartition(a, low, high);

        assertTrue(isPartitionedLomuto(a, low, high, p, pivotVal));
    }

    @Test
    void hoare_sortedArray() {
        int[] a = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int low = 0, high = a.length - 1;
        int pivotVal = a[(low + high) / 2];

        int j = Partitions.hoarePartition(a, low, high);

        assertTrue(j >= low && j < high);
        assertTrue(isPartitionedHoare(a, low, high, j, pivotVal));
    }

    @Test
    void hoare_emptyArray_throws() {
        int[] a = {};
        assertThrows(IllegalArgumentException.class, () -> Partitions.hoarePartition(a, 0, 0));
    }

    @Test
    void hoare_randomArray() {
        int[] a = {84, 3, 7, 1, 9, 6, 2, 5};
        int low = 0, high = a.length - 1;
        int pivotVal = a[(low + high) / 2];

        int j = Partitions.hoarePartition(a, low, high);

        assertTrue(j >= low && j < high);
        assertTrue(isPartitionedHoare(a, low, high, j, pivotVal));
    }
}
