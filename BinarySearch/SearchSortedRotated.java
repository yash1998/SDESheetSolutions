package BinarySearch;

import java.util.ArrayList;

public class SearchSortedRotated {

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int st = 0, en = n-1;

        while(st<=en) {
            int mid = st + (en-st)/2;

            if (arr.get(mid) == k) return mid;

            if (arr.get(0) > arr.get(mid)) {
                if (arr.get(mid) < k && k <= arr.get(n-1)) {
                    st = mid+1;                    
                } else {
                    en = mid-1;
                }
            } else {
                if (arr.get(0) <= k && k < arr.get(mid)) {
                    en = mid-1;
                } else {
                    st = mid+1;
                }
            }
        }
        return -1;
    }
    
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        int n = A.length, st = 0, en = n-1;

        while(st<=en) {
            int mid = st + (en-st)/2;

            if (A[mid] == key) return true;

            if (A[st] == A[mid] && A[mid] == A[en]) {
                // skip duplicates
                st++;
                en--;
                continue;
            } else if (A[st] > A[mid]) {
                if (A[mid] <= key && key <= A[en]) {
                    st = mid+1;        
                } else {
                    en = mid-1;
                }
            } else {
                if (A[st] <= key && key <= A[mid]) {
                    en = mid-1;
                } else {
                    st = mid+1;
                }
            }
        }

        return false;
    }

    public static int findMin(int[] nums) {
        int n = nums.length, st = 0, en = n-1;

        while (st <= en) {
            int mid = st + (en-st)/2;

            // if prev greater than mid, then current is the min
            if (mid-1 >=0 && nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            // if current greater than next, then next is the min
            if (mid+1 < n && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }

            // if first element greater then
            // left part unsorted and min can be found in left
            if (nums[0] > nums[mid]) {
                en = mid-1;
            }
            // right part unsorted and min can be found in right
            else {
                st = mid+1;
            }
        }

        return nums[0];
    }
}
