package Arrays;

public class Kadane {
    public static long maxSubarraySum(int[] arr, int n) {
		long sum = 0, res = arr[0];
		for(int i =0; i<n;i++) {
			sum += arr[i];
			if (sum > res) res = sum;
			if (sum < 0) sum = 0;
		}
		if(res < 0) {
			return 0L;
		}

		return res;

	}  
}
