package LeetCode.TwoPointers;

public class FirstOccurrence {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean isMatch = true;
            for (int charIndx = 0; charIndx < needle.length(); charIndx++) {
                if(haystack.charAt(charIndx + i) != needle.charAt(charIndx)){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                return i;
            }
        }
        return -1;
    }
}
