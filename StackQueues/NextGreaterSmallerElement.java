package StackQueues;

import java.util.Stack;

public class NextGreaterSmallerElement {
    
    public static int[] nextGreaterElement(int[] arr, int n) {
        if (n == 0) return new int[]{};

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        // FOR PREVIOUS SMALLER/GREATER ELEMENT,
        // loop will start from 0 to n
        // for(int i=0; i<n; i++) {
        for(int i=n-1; i>=0; i--) {

            // FOR NEXT SMALLER ELEMENT, condition will be reverse st.peek() >= arr[i])
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return res;
    }

    public static int[] nextSmallerElement(int[] arr, int n) {
	    int[] res = new int[n];
	    Stack<Integer> st = new Stack<>();
	    
	    for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
	    }
	    
	    return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[]{};

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            st.push(nums[i]);
        }
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}
