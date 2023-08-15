package Arrays;

import java.util.ArrayList;

public class DutchNational {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int low = 0, mid = 0, high = n-1;

        while(mid <= high) {
            if (arr.get(mid) == 0) {
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                mid++;
                low++;
            } else if(arr.get(mid) == 1) {
                mid++;
            } else {
                int temp = arr.get(high);
                arr.set(high, arr.get(mid));
                arr.set(mid, temp);
                high--;
            }
        }
    }
}
