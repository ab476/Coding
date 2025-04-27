package ApnaCollege.Recursion_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecursionBasics {
    public static void printBinaryStrings(int n) {
        printBinaryStrings(n, new StringBuilder());
    }
    public static void printBinaryStrings(int n, StringBuilder sb) {
        if (n == 0) {
            System.out.println(sb);
            return;
        }
        sb.append('0');
        printBinaryStrings(n - 1, sb);
        sb.deleteCharAt(sb.length() - 1); // backtrack
        if(sb.length() == 0 || sb.charAt(sb.length() - 1) == '0') {
            sb.append('1');
            printBinaryStrings(n - 1, sb);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        numToString(349, list);
        System.out.println(String.join(" ", list));
    }

    public static void findAllIndex(int[] arr, int target, int index){

    }
    public static void numToString(int n, List<String> list) {
        if (n == 0) {
            Collections.reverse(list);
            return;
        }
        int lastDigit = n % 10;
        switch (lastDigit) {
            case 0 -> list.add("zero");
            case 1 -> list.add("one");
            case 2 -> list.add("two");
            case 3 -> list.add("three");
            case 4 -> list.add("four");
            case 5 -> list.add("five");
            case 6 -> list.add("six");
            case 7 -> list.add("seven");
            case 8 -> list.add("eight");
            case 9 -> list.add("nine");
            default -> list.add("Invalid");
        }
        numToString(n / 10, list);
    }
}