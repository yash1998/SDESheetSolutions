package Arrays;

public class MaxProductSubarr {
    public static int subarrayWithMaxProduct(int []arr){
        int n = arr.length;
        long prefixMultiply = 1, suffixMultiply = 1, maxProduct = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            if (arr[i] == 0) prefixMultiply = 1;
            else {
                prefixMultiply *= arr[i];
                if (prefixMultiply > maxProduct) maxProduct = prefixMultiply;
            }
        }

        for(int i=n-1; i>=0; i--) {
            if (arr[i] == 0) suffixMultiply = 1;
            else {
                suffixMultiply *= arr[i];
                if (suffixMultiply > maxProduct) maxProduct = suffixMultiply;
            }
        }   
        return (int)maxProduct;
    }
}
