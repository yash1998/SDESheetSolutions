package BinarySearch;

public class FindMinSortedRotated {
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

    public static int findKRotation(int []arr){
        int n= arr.length, st = 0, en = n-1;

        while(st<=en) {

            int mid = st + (en-st)/2;

            if(mid-1 >=0 && arr[mid-1] > arr[mid]) {
                return mid;
            }
            if(mid+1 <n && arr[mid] > arr[mid+1]) {
                return mid+1;
            }

            if (arr[0] > arr[mid]) {
                en = mid-1;
            } else{
                st = mid+1;
            }
        }

        return 0;
    }


    
}
