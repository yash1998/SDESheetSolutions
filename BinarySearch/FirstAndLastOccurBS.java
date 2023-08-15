package BinarySearch;

public class FirstAndLastOccurBS {
    public static int count(int arr[], int n, int k) {
        //Your code goes here
        int firstOccurence = -1, lastOccurence = -1, st = 0, en = n-1;
        while(st<=en) {
            int mid = st + (en-st)/2;

            if(arr[mid] == k) {
                // if item is 0th idx, then automatically it's the first occur else if previous element is not equal to current element, then it's the first occurence
                if (mid == 0 || (mid-1 >= 0 && arr[mid-1] != k)) {
                    firstOccurence = mid;
                    break;
                } else {
                    // since we're searching for first occur, it should be on left part of arr
                    en = mid-1;
                }
            } else if (k > arr[mid]) {
                // normal BS
                st = mid+1;
            } else {
                // normal BS
                en = mid-1;
            }
        }
        st = 0;
        en = n-1;
        while(st<=en) {
            int mid = st + (en-st)/2;

            if(arr[mid] == k) {
                // if item is last idx, then automatically it's the last occur else if next element is not equal to current element, then it's the last occurence
                if (mid == n-1 || (mid+1 < n && arr[mid+1] != k)) {
                    lastOccurence = mid;
                    break;
                } else {
                    // since we're searching for last occur, it should be on right part of arr
                    st = mid+1;
                }
            } else if (k > arr[mid]) {
                // normal BS
                st = mid+1;
            } else {
                // normal BS
                en = mid-1;
            }
        }
        // either is -1, that means element not found
        if (firstOccurence == -1 || lastOccurence == -1) return 0;
        return lastOccurence-firstOccurence+1; // freq of element
    }
}

