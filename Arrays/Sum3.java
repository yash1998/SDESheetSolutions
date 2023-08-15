package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++) {

            // Skipping duplicates for i
            if (i != 0 && arr[i] == arr[i - 1]) continue;
            int j = i+1, k = n-1;
            while(j < k) {
                int x = arr[i] + arr[j] + arr[k];
                if (x == 0) {
                    // triplet found, store it
                    result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    // Skipping duplicates for j
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    // Skipping duplicates for k
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (x < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    // hashing based
    public List<List<Integer>> threeSumHashing(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0; i< n;i++) {
            set2.clear();
            for(int j=i+1; j<n; j++) {
                int third = -(arr[i]+arr[j]);
                if (set2.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    set1.add(temp);
                }
                set2.add(arr[j]);
            }
        }

        List<List<Integer>> result = new ArrayList<>(set1);
        return result;
    }
}
