package Arrays;

import java.util.HashSet;

public class LongestSuccessiveElements {
    public static int longestSuccessiveElements(int []a) {
        int n = a.length, maxx = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }

        for(int i=0; i<n; i++) {
            if (!set.contains(a[i]-1)) {
                int j = a[i]+1, count = 1;
                while(set.contains(j)) {
                    count++;
                    j++;
                }
                if (count > maxx) maxx = count;
            }
        }

        return maxx;
    }
}
