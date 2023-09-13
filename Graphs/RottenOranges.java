package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int minTimeToRot(int[][] grid, int n, int m) {
        int timeTaken = 0;
        Queue<Pair> que = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();
            timeTaken++;
            for (int k = 0; k < size; k++) {
                Pair p = que.poll();
                int i = p.i, j = p.j;
                vis[i][j] = true;
                checkNeighbor(vis, que, grid, i - 1, j, n, m);
                checkNeighbor(vis, que, grid, i + 1, j, n, m);
                checkNeighbor(vis, que, grid, i, j - 1, n, m);
                checkNeighbor(vis, que, grid, i, j + 1, n, m);
            }
        }
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                if (!vis[k][l] && grid[k][l] == 1) {
                    return -1;
                }
            }
        }
        return timeTaken == 0 ? 0 : timeTaken - 1;
    }

    private static void checkNeighbor(boolean[][] vis, Queue<Pair> que, int[][] grid, int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1 && !vis[i][j]) {
            vis[i][j] = true;
            que.add(new Pair(i, j));
        }
    }

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
