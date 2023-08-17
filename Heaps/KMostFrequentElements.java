package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentElements {
    static class MapObj implements Comparable<MapObj> {
		int key, val;

		MapObj(int k, int v) {
			key = k;
			val = v;
		}

		public int compareTo(MapObj ob) {
			return Integer.compare(val, ob.val);
		}

	}

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		int res[] = new int[k];
		HashMap<Integer, Integer> freq = new HashMap<>();
		PriorityQueue<MapObj> pq = new PriorityQueue<>();

		for(int i=0 ;i<n; i++) {
			freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
		}

		for (Map.Entry<Integer, Integer> item : freq.entrySet()) {
			pq.add(new MapObj(item.getKey(), item.getValue()));
		}
		for (int i = 0; i < k; i++) {
            res[i] = pq.poll().key;
        }

		return res;
	}
    
}
