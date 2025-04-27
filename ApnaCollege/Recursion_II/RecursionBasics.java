package ApnaCollege.Recursion_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
    public record  Tuple<T1, T2>(T1 first, T2 second) {
    }
    public static int findSubstringWithSameChar(String str){
        return findSubstringWithSameChar(str, 0, str.length() - 1, new HashSet<>());
    }
    private static int findSubstringWithSameChar(String str, int start, int end, HashSet<Tuple<Integer, Integer>> set) {
        int count = 0;
        if(start < end) {
            count += findSubstringWithSameChar(str, start + 1, end, set);
            count += findSubstringWithSameChar(str, start, end - 1, set);
        }
        if(start <= end && str.charAt(start) == str.charAt(end) && !set.contains(new Tuple<>(start, end))) {
            set.add(new Tuple<>(start, end));
            count++;
        }
        return count;
    }

    public static void towerOfHanoi(int n, String src, String dest, String helper) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }
        towerOfHanoi(n - 1, src, helper, dest);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, dest, src);
    }
    public static void main(String[] args) {
        towerOfHanoi(3, "A", "C", "B");
    }
}