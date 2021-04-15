package algorithms.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SortName implements Comparator<String> {
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

public class NameSort {
    public static void main(String[] args) {
        ArrayList<String> nameArray = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        /*
         * Ideally you would use code like this
         * String x = System.console().readLine();
         *
         * but Intellij does gracefully support this, and System.console() returns null
         *
         * The problem you're having is tht scanner.nextLine() grabs whatever is on the current line of input
         * and returns immediately.  THis is another method, scanner.next() which will wait for the next "token".
         * I made the change below.  Plase let me know if you need anything else.
         */

        System.out.println("Number of names: ");
        int names = scanner.nextInt();

        for (int i = 0; i <= names; i++) {
            System.out.println("Name " + i + ": ");
            String name = scanner.next();

            nameArray.add(name);
        }

        Collections.sort(nameArray, new SortName());

        for (String name : nameArray) {
            System.out.println(name);
        }
    }
}