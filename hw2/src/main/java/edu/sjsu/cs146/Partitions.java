package edu.sjsu.cs146;

public final class Partitions {
    private Partitions() {}

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Lomuto: pivot = a[high], returns final pivot index
    public static int lomutoPartition(int[] a, int low, int high) {
        if (a == null) throw new IllegalArgumentException("array is null");
        if (low < 0 || high >= a.length || low > high)
            throw new IllegalArgumentException("invalid bounds");

        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    // Hoare: pivot = a[(low+high)/2], returns split index j
    public static int hoarePartition(int[] a, int low, int high) {
        if (a == null) throw new IllegalArgumentException("array is null");
        if (low < 0 || high >= a.length || low > high)
            throw new IllegalArgumentException("invalid bounds");

        int pivot = a[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do { i++; } while (a[i] < pivot);
            do { j--; } while (a[j] > pivot);

            if (i >= j) return j;

            swap(a, i, j);
        }
    }
}