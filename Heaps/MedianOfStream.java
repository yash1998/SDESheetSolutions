package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

    public static int[] findMedian(int[] arr, int n) {
        PriorityQueue<Integer> g = new PriorityQueue<>();
        PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0, res[] = new int[n];
        s.add(arr[0]);
        res[i++] = arr[0];
        for(int j=1; j<n; j++) {
            if (s.size() > g.size()) {
                if (s.peek() > arr[i]) {
                    g.add(s.poll());
                    s.add(arr[i]);
                } else {
                    g.add(arr[i]);
                }
                res[i++] = (s.peek() + g.peek())/2;
            } else {
                if (arr[i] <= s.peek()) {
                    s.add(arr[i]);
                } else {
                    g.add(arr[i]);
                    s.add(g.poll());
                }
                res[i++] = s.peek();
            }
        }

        return res;
    }
    
}
