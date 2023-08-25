package StackQueues;

public class TrappingRainwater {
    public int trap(int[] arr) {
        int n = arr.length;
        int left = 0, right = n-1;
        int summ = 0;
        int prevLeft = arr[0], prevRight = arr[n-1];
        while(left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > prevLeft) {
                    prevLeft = arr[left];
                } else {
                    summ += prevLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] > prevRight) {
                    prevRight = arr[right];
                } else {
                    summ += prevRight - arr[right];
                }
                right--;
            }
        }
        return summ;
    }
}
