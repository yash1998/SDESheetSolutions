package Graphs;

import java.util.*;

public class DistanceOfNearest1 {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                res.get(i).add(0);
            }
        }
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == 1) {
                    que.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            Pair p = que.poll();
            res.get(p.i).set(p.j, p.dist);
            check(p.i - 1, p.j, p.dist, vis, n, m, que);
            check(p.i + 1, p.j, p.dist, vis, n, m, que);
            check(p.i, p.j - 1, p.dist, vis, n, m, que);
            check(p.i, p.j + 1, p.dist, vis, n, m, que);
        }

        return res;

    }

    public static void check(int i, int j, int dist, boolean[][] vis, int n, int m, Queue<Pair> que) {
        if (i >= 0 && i < n && j >= 0 && j < m && !vis[i][j]) {
            vis[i][j] = true;
            que.add(new Pair(i, j, dist + 1));
        }
    }

    static class Pair {
        int i, j, dist;

        Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
}