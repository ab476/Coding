package ApnaCollege.Recursion_II;
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
        int n = 3; // Length of binary strings
        printBinaryStrings(n);
    }
}