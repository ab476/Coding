package ApnaCollege.StacksAndQueues;

public class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for(int i = 0; i < tickets.length; i ++) {
            if(i < k) {
                time += Math.min(tickets[i], tickets[k]);
            } else if (i == k) {
                time += tickets[k];
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return time;
    }
}
