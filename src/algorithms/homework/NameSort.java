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
    public static void main(String[] args) {

        String[] names = {"Sean", "Bob", "Steve", "John"};
        NameSort.sort(names);
    }

    public static void sort(String[] names) {
        ArrayList<ArrayList<Integer>> Names = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            Names.add(new ArrayList<>());
            for (int j = 0; j < names[i].length(); j++) {
                Names.get(i).add(Character.getNumericValue(names[i].charAt(j)) - 10);
            }
        }
        System.out.println(Names);
    }
}
