package BinarySearch;

import java.util.ArrayList;

public class FindPeak {

    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size(), st = 1, en = n-2;

        if (n==1) return 0;
        
        if (arr.get(0) > arr.get(1)) return 0;
        if (arr.get(n-1) > arr.get(n-2)) return n-1;

        while(st<=en) {
            int mid = st + (en-st)/2;

            if (arr.get(mid-1) < arr.get(mid) && arr.get(mid+1) < arr.get(mid)) {
                return mid;
            }
            if (arr.get(mid-1) < arr.get(mid)) {
                st = mid+1;
            }
            else if (arr.get(mid+1) < arr.get(mid)){
                en = mid-1;
            } else {
                // for lowest pt case
                // any way I can go 
                st = mid+1;
            }
        }
        return -1;
    }
    
}
