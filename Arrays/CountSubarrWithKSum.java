package Arrays;

import java.util.HashMap;

public class CountSubarrWithKSum {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length, preSum = 0, count = 0;
        
        for(int i=0; i<n; i++) {
            preSum += arr[i];
            if(preSum == s) count++;
            count += map.getOrDefault(preSum-s, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static int subarraysWithXORK(int []arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length, preSum = 0, count = 0;
        
        for(int i=0; i<n; i++) {
            preSum ^= arr[i];
            if(preSum == k) count++;
            count += map.getOrDefault(preSum^k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
    
}
