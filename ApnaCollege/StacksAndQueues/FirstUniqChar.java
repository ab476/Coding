package ApnaCollege.StacksAndQueues;

class FirstUniqChar {
    public int firstUniqChar(String s) {
        var freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}