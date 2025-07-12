package LeetCode.String;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean found = false;
        for(int i = s.length() - 1; i >= 0; i--){

            if(s.charAt(i) != ' '){
                length++;
                found = true;
            } else if(found) {
                break;
            }
        }
        return length;
    }
}
