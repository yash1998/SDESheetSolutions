package Heaps;

import java.util.ArrayList;

public class MinHeap {
    static ArrayList<Integer> hp = new ArrayList<>();

    static int[] minHeap(int n, int[][] q) {
        ArrayList<Integer> result = new ArrayList<>();
        hp.clear();

        for(int i=0; i<n; i++) {
            if(q[i][0] == 0) {
                insertMinHeap(q[i][1]);
            } else {
                result.add(extractMinHeap());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static int parentMinHeap(int i) {
        return (int)((i-1)/2);
    }

    static void insertMinHeap(int x) {
        if (hp.size() == 0) {
            hp.add(x);
            return;
        }
        hp.add(x);
        int tt = hp.size()-1;
        while (tt > 0 && hp.get(parentMinHeap(tt)) > hp.get(tt)) {
            int temp = hp.get(parentMinHeap(tt));
            hp.set(parentMinHeap(tt), hp.get(tt));
            hp.set(tt, temp);
            tt = parentMinHeap(tt);
        }
    }

    static int right(int i) {
        return (2*i)+2;
    }

    static int left(int i) {
        return (2*i)+1;
    }

    static void heapify(int i) {
        int lt = left(i), rt = right(i), smallest = i;
        if (lt < hp.size() && hp.get(lt) < hp.get(smallest)) {
            smallest = lt;
        }
        if (rt < hp.size() && hp.get(rt) < hp.get(smallest)) {
            smallest = rt;
        }
        if(smallest != i) {
            int temp = hp.get(smallest);
            hp.set(smallest, hp.get(i));
            hp.set(i, temp);
            heapify(smallest);
        }

    }

    static int extractMinHeap() {
        if (hp.size() == 0) return Integer.MAX_VALUE;
        if (hp.size() == 1) {
            return hp.remove(0);
        }
        int last = hp.size()-1, temp = hp.get(0);
        hp.set(0, hp.get(last));
        hp.set(last, temp);
        
        int lastEle = hp.remove(last);
        heapify(0);
        return lastEle;
    }
    
}
