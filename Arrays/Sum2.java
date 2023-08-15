package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Sum2 {
    public static String sum2(int n, int []book, int target){

        return sum2solve1(n, book, target);
        // return sum2solve2(n, book, target);
    }

    public static String sum2solve1(int n, int[] book, int target) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            if (set.contains(target-book[i])) {
                return "YES";
            }
            set.add(book[i]);
        }
        return "NO";
    }

    public static String solve2(int n, int[] book, int target) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            pairs.add(new Pair(book[i], i));
        }

        Collections.sort(pairs);

        int i =0, j = n-1, summ = 0;
        while(i<j) {
            summ = pairs.get(i).first + pairs.get(j).first;
            if (summ == target) return "YES";
            if (summ < target) {
                i++;
            } else {
                j--;
            }
        }

        return "NO";
    }

    public static class Pair implements Comparable<Pair>{
        int first, second;
        Pair(int f, int s) {
            first = f;
            second = s;
        }

        @Override
        public int compareTo(Pair p){
            return Integer.compare(first, p.first);
        }
    }
      
}
