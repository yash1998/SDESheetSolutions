package Arrays;

import java.util.HashMap;

public class LongestSubarrWithKSum {

    // Best solution for only positives
    public static int longestSubarrayWithSumKOnlyPos(int[] a, long k) {
        int n = a.length, count = 0, st = 0, en = 0;
        long summ = a[0];

        while (en < n) {
            while (st <= en && summ > k) {
                summ -= a[st];
                st++;
            }
            if (summ == k) {
                count = Math.max(count, en - st + 1);
            }
            en++;
            if (en < n)
                summ += a[en];
        }

        return count;
    }

    // Best solution for positives/negatives
    public static int getLongestSubarrayWithPosNeg(int[] a, int k) {
        int n = a.length, count = 0;
        long summ = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            summ += a[i];
            if (summ == k) {
                count = Math.max(count, i + 1);
            }
            long rem = summ - k;
            if (map.containsKey(rem)) {
                count = Math.max(count, i - map.get(rem));
            }
            if (!map.containsKey(summ)) {
                map.put(summ, i);
            }
        }

        return count;
    }
}