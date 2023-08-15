package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MooreVoting {

    // Majority element >n/2 times
    public static int majorityElement2(int []v) {
        int n = v.length, maybeRes = -1, count = 0;

        for(int i=0; i<n; i++) {
            if(count ==0) {
                maybeRes = v[i];
                count++;
            } else {
                if (maybeRes == v[i]){
                    count++;
                } else {
                    count--;
                }
            }
        }

        count = 0;
        for(int i=0; i<n; i++) {
            if (maybeRes == v[i]) count++;
        }
        if (count > (int)(n/2)) return maybeRes;
        return -1;
    }

    // Majority element >n/3 times
    public static List< Integer > majorityElement3(int []v) {
        int n = v.length, maybeRes1 = -1, maybeRes2 = -1, count1 = 0, count2 = 0;

        for(int i=0; i<n; i++) {
            if(count1 == 0 && v[i] != maybeRes2) {
                maybeRes1 = v[i];
                count1++;
            } else if(count2 == 0 && v[i] != maybeRes1) {
                maybeRes2 = v[i];
                count2++;
            } else if (maybeRes1 == v[i]){
                count1++;
            } else if (maybeRes2 == v[i]){
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i=0; i<n; i++) {
            if (maybeRes1 == v[i]) count1++;
            if (maybeRes2 == v[i]) count2++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int x = (int)(n/3);
        if (maybeRes1 < maybeRes2) {
            if (count1 > x) res.add(maybeRes1);
            if (count2 > x) res.add(maybeRes2);
        } else {
            if (count2 > x) res.add(maybeRes2);
            if (count1 > x) res.add(maybeRes1);
        }
        return res;
    }
}
