package algorithms.homework;

import java.util.ArrayList;

class Quick_Sort {
    static int increment = 0;

    static void swap(ArrayList<ArrayList<Integer>> arr, int i, int j) {
        ArrayList<Integer> temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(ArrayList<ArrayList<Integer>> arr, int low, int high) {
        // pivot
        Integer pivot = arr.get(high).get(increment);

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (arr.get(j).get(increment) < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }

        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(ArrayList<ArrayList<Integer>> arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array
    static void printArray(ArrayList<ArrayList<Integer>> arr, int size) {
        for(int i = 0; i < size; i++)
            System.out.print(arr.get(i) + " ");

        System.out.println();
    }

 /*   // Driver Code
    public static void main(String[] args) {
        int [] array = {10, 7, 8, 9, 1, 5 };
        int n = array.length;

        quickSort(array, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(array, n);
    }

  */
}