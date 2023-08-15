package Arrays;

public class FindMissingAndRepeatingNum {
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        int n = a.length, z = 0;

        for(int i=0; i<n; i++) {
            z^= a[i];
            z^= (i+1);
        }

        int count=0;
        while(z>0) {
            if ((z&1) != 0) break;
            count++;
            z >>= 1;
        }
        
        int bucket1Xor = 0, bucket2Xor = 0, move = 1<<count;
        for(int i=1; i<=n; i++) {
            if ((i & move) != 0) {
                bucket1Xor^= i;
            } else {
                bucket2Xor^= i;
            }
            if ((a[i-1] & move) != 0) {
                bucket1Xor^= a[i-1];
            } else {
                bucket2Xor^= a[i-1];
            }
        }
        count = 0;
        for(int i: a) {
            if (bucket1Xor == i) count++;
        }
        if (count == 2) return new int[]{bucket1Xor, bucket2Xor};
        return new int[]{bucket2Xor, bucket1Xor};
    }
    
}
