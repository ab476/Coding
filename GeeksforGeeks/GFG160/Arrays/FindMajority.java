import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;

public class FindMajority {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        var map = new Hashtable<Integer, Integer>();
        var list = new ArrayList<Integer>();
        for(int num : arr) {
            var count = map.containsKey(num) ? map.get(num) : 0;
            count++;
            map.put(num,  count);
            
            if(count >= arr.length / 3) {
                list.add(num);
            }
        }
        for(var entry : map.entrySet()) {
            if(entry.getValue() >= arr.length / 3) {
                list.add(entry.getKey());
            }
        }
        var comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        list.sort(comparator);
        return list;
    }
}
