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

        System.out.println("Number of names: ");
        int names = scanner.nextInt();

        for (int i = 0; i <= names; i++) {
            System.out.println("Name " + i + ": ");
            String name = scanner.nextLine();
            nameArray.add(name);
        }

        Collections.sort(nameArray, new SortName());

        for (String name : nameArray) {
            System.out.println(name);
        }
    }
}