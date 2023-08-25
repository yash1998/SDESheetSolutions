package StackQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestAreaHist {
    public static int largestRectangle(ArrayList<Integer> heights) {
        int n = heights.size();

        // Finding previous smaller and next smaller
        int[] prev = new int[n], next = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights.get(st.peek()) >= heights.get(i)) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights.get(st.peek()) >= heights.get(i)) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights.get(i) * (next[i] - prev[i] - 1));
        }

        return maxArea;
    }

    // max area rectangle in binary matrix
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        
        int[] heights = new int[n]; 
        Arrays.fill(heights, 0);
        int maxx = 0;
        for(int i=0; i<matrix.length;i++) {
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            // maxx = Math.max(maxx, largestRectangle(heights, n));
        }

        return maxx;
    }
}
