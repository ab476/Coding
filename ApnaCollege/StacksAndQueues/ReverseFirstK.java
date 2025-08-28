package ApnaCollege.StacksAndQueues;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if(q.size() < k) {
            return q;
        }
        var stack = new Stack<Integer>();
        for(int i = 0; i < k; i++) {
            stack.push(q.remove());
        }
        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }
        for(int i = 0; i < (q.size() - k); i++) {
            q.add(q.remove());
        }
        return q;
    }
}
