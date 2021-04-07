package algorithms.homework;

import java.util.ArrayList;

public class NameSort {
    /*
    1. Convert each name into a series of integers, store in array.
    Each name will be an array, with each array being an element in another array

    2. Get first integer out of each array in Names, and use Quicksort. Shift names while doing so.

    3. If any integers are the same, repeat with the second integer in those arrays, repeat if necessary.

    4. Print names.
    */

   // Quick_Sort quickSort = new Quick_Sort();

    public static void main(String[] args) {

        String[] names = {"Sean", "Bob", "Steve", "John", "Liam", "Noah", "Oliver", "William"};
        NameSort.sort(names);
        NameSort.convertList();
    }

    static ArrayList<ArrayList<Integer>> compareArr = new ArrayList<>();

    public static void sort(String[] names) {
        Quick_Sort quick_sort = new Quick_Sort();
        ArrayList<ArrayList<Integer>> Names = new ArrayList<>();


        int len = names.length;
        for (int i = 0; i < len; i++) {
            Names.add(new ArrayList<>());
            for (int j = 0; j < names[i].length(); j++) {
                Names.get(i).add(Character.getNumericValue(names[i].charAt(j)) - 10);
            }
            compareArr.add(Names.get(i));
        }
        System.out.println(Names);

        quick_sort.quickSort(compareArr, 0, len - 1);
        System.out.println("Sorted array: ");
        quick_sort.printArray(compareArr, len);


    }
    public static void convertList() {
        StringBuilder sortedNames = new StringBuilder();
        for (int i = 0; i < compareArr.size(); i++) {
            int k = compareArr.get(i).size();
            for (int j = 0; j < k; j++) {
                int l = compareArr.get(i).get(j);
                l += 97;
                // Base 10 => ASCII characters (a, b, c...)
                String str = Character.toString((char) l);
                // adding letters to encrypted/decrypted message using StringBuilder
                sortedNames.append(str);
            }
            if (i < compareArr.size() - 1) {
                sortedNames.append(", ");
            }
        }
        System.out.println(sortedNames);
    }
}
