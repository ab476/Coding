package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        var res = new ArrayList<String>();
        generateParenthesis(0, 0, "", n, res);
        return res;
    }
    public void generateParenthesis(int openCount, int closeCount, String current,int n, List<String> res){
        if(openCount == n && closeCount == n) {
            res.add(current);
        }
        if(openCount > n || closeCount > n || closeCount > openCount) {
            return;
        }
        generateParenthesis(openCount + 1, closeCount, current + "(", n, res);
        generateParenthesis(openCount, closeCount + 1, current + ")", n, res);
    }
}
