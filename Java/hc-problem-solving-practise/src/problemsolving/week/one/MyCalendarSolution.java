package problemsolving.week.one;

import java.util.HashMap;
import java.util.Map;

public class MyCalendarSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// TC: O(N log C) SC: O(N) 732. My Calendar III
/*
Let NN be the number of events booked and CC be the largest time (i.e., 10^910 
9
  in this problem)

Time Complexity: O(N log{C})O(NlogC). The max possible depth of the segment tree is O(logC). 
At most O(log{C})O(logC) nodes will be visited in each update operation. Thus, the time complexity of booking NN new events is O(NlogC)
O(NlogC).
Space Complexity: O(NlogC). Instead of creating a segment tree of 4C4C at first, we create tree nodes dynamically when needed.
Every time update is called, we create at most O(NlogC) nodes because the max depth of the segment tree is logC. */

class MyCalendarThree {
    private Map<Integer, Integer> vals;
    private Map<Integer, Integer> lazy;

    public MyCalendarThree() {
        vals = new HashMap<>();
        lazy = new HashMap<>();                                                                                                                     
    }

    public void update(int start, int end, int left, int right, int idx) {
        if (start > right || end < left)
            return;
        if (start <= left && right <= end) {
            vals.put(idx, vals.getOrDefault(idx, 0) + 1);
            lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);
        } else {
            int mid = (left + right) / 2;
            update(start, end, left, mid, idx * 2);
            update(start, end, mid + 1, right, idx * 2 + 1);
            vals.put(idx, lazy.getOrDefault(idx, 0)
                    + Math.max(vals.getOrDefault(idx * 2, 0), vals.getOrDefault(idx * 2 + 1, 0)));
        }
    }

    public int book(int start, int end) {
        update(start, end - 1, 0, 1000000000, 1);
        return vals.getOrDefault(1, 0);
    }
}
