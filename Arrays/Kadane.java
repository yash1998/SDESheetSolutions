package Arrays;

import java.util.ArrayList;

public class Kadane {
    public int maxSubArray(int[] nums) {
        int preSum = 0, maxx = Integer.MIN_VALUE;
        int st = 0, en = 0;
        for(int i=0; i<nums.length; i++) {
            preSum += nums[i];
            if (preSum > maxx) {
                maxx = preSum;
                en = i;
            }
            if (preSum < 0) {
                preSum = 0;
            }
        }
        int temp = maxx;
        for(int i=en; i>=0; i--) {
            temp -= nums[i];
            if (temp == 0) {
                st = i;
                break;
            }
        }

		// Printing the start and end idx of max subarr sum
        System.out.println("st: "+st+", en:"+en);

        return maxx;
    }
}
