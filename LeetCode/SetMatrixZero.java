import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            var row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    row[j] = 0;
                } else if (row[j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                    int colNo = j - 1;
                    while (colNo >= 0) {
                        row[colNo--] = 0;
                    }
                    int rowNo = i;
                    while (rowNo >= 0) {
                        matrix[rowNo--][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int[][] matrix = Arrays.stream(
            sc.nextLine().replaceAll("[\\[\\]]", "").split("],\\["))
                .map(row -> Arrays.stream(row.split(",")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

                new SetMatrixZero().setZeroes(matrix);
        sc.close();
    }
}
