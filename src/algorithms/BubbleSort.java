package algorithms;

// 2, 7, 8, -15, 12
// 2, 7, -15, 8, 12
// 2, -15, 7, 8, 12
// Always runs in O(n^2)
// Best case O(n)
class BubbleSort {
    void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean didSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
            }
            if(didSwap) {
                break;
            }
        }

        //forloop

    }

    /* Prints the array */
    void printArray(int[] arr) {
        int n = arr.length;
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver method to test above
    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}