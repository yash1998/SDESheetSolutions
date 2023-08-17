package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestSmallest {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i = 0; i<k; i++) {
			minPq.add(arr.get(i));	// for finding kth largest
			maxPq.add(arr.get(i));	// for finding kth smallest
		}

		for(int i=k; i<n; i++) {
			if (maxPq.peek() > arr.get(i)) {
				maxPq.poll();
				maxPq.add(arr.get(i));
			}
			if (minPq.peek() < arr.get(i)) {
				minPq.poll();
				minPq.add(arr.get(i));
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		res.add(maxPq.peek());
		res.add(minPq.peek());
		return res;
	}
}
