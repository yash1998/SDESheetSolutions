package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeOverlaps {
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length;
        List<Pair> ar = new ArrayList<>();
        for(int[] i: arr){
            ar.add(new Pair(i[0], i[1]));
        }
        Collections.sort(ar);

        List<List<Integer>> result = new ArrayList<>();
        Pair prev = ar.get(0);
        for(int i=1; i<n; i++) {
            Pair curr = ar.get(i);
            if (curr.start <= prev.end) {
                if (curr.end > prev.end) prev.end = curr.end;
            } else {
                result.add(Arrays.asList(prev.start, prev.end));
                prev = curr;
            }
        }
        result.add(Arrays.asList(prev.start, prev.end));

        return result;
    }

    static class Pair implements Comparable<Pair>{
        int start, end;

        Pair(int st, int en) {
            start = st;
            end = en;
        }

        public int compareTo(Pair p) {
            if (start == p.start) {
                return Integer.compare(end, p.end);
            }
            return Integer.compare(start, p.start);
        }
    }
}
