package BinarySearch;

import java.util.ArrayList;

public class SingleInSortedArr {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size(), st = 0, en = n-1;

        while(st <= en) {
            int mid = (st+en)/2, prev = mid-1, next = mid+1;
            
            boolean isPrevDup = false, isNextDup = false;
            if (prev >= 0 && arr.get(prev).equals(arr.get(mid))) {
                isPrevDup = true;
            }
            if (next < n && arr.get(next).equals(arr.get(mid))) {
                isNextDup = true;
            }
            if (!isPrevDup && !isNextDup) {
                return arr.get(mid);
            }
            if (isPrevDup) {
                if (mid%2 == 1) {
                    st = mid+1;
                } else {
                    en = mid-2;
                }
            } else if (isNextDup) {
                if (mid%2 == 1) {
                    en = mid-1;
                } else {
                    st = mid+2;
                }
            }
        }
        return -1;
    }
}
