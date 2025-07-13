package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        var row = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            row.add(1); // last elemnt
            // start from last so wee dont use curently updsted value
            for(int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}