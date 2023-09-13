package SlidingWindow;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class FlipZerosMaxConsecOnes {
    public int longestOnes(int[] nums, int k) {
        int st = 0, en = 0;

        int c = 0, res = 0;
        while(en < nums.length) {
            if (nums[en] == 0) c++;
            while (c > k) {
                if (nums[st] == 0) c--;
                st++;
            }
            res = Math.max(res, en-st+1);
            en++;
        }

        return res;
    }
}
