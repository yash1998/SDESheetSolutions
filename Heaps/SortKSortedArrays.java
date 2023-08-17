package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortKSortedArrays {
	static class MyObj implements Comparable<MyObj> {
		int val, valPos, arrPos;

		MyObj(int v, int vp, int ap) {
			val = v; // value of item
			valPos = vp; // idx in array
			arrPos = ap; // array index in K arrays
		}

		public int compareTo(MyObj ob) {
			// when put in min heap, it compares only values
			return Integer.compare(val, ob.val);
		}

	}

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
		// Write your code here.
		ArrayList<Integer> res = new ArrayList<>();

		// create min heap
		PriorityQueue<MyObj> pq = new PriorityQueue<>();

		// add all arrays 0th element
		for (int i = 0; i < k; i++) {
			MyObj temp = new MyObj(kArrays.get(i).get(0), 0, i);
			pq.add(temp);
		}

		// while heap's not empty
		while (!pq.isEmpty()) {
			MyObj temp = pq.poll(); // extract min
			res.add(temp.val); // add it in result

			// check for adding next element of the min extracted array
			if (temp.valPos + 1 < kArrays.get(temp.arrPos).size()) {
				MyObj temp2 = new MyObj(kArrays.get(temp.arrPos).get(temp.valPos + 1), temp.valPos + 1, temp.arrPos);
				pq.add(temp2);
			}
		}

		return res;
	}

}
