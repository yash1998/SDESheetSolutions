package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
        Queue<Pair> que = new LinkedList<>();

        int flooder = image[x][y];
        que.offer(new Pair(x, y));

        while(!que.isEmpty()) {
            Pair node = que.poll();
            int i = node.i, j = node.j;
            image[i][j] = p;
            checkNeighbors(image, n, m, i-1, j, flooder, que);
            checkNeighbors(image, n, m, i+1, j, flooder, que);
            checkNeighbors(image, n, m, i, j-1, flooder, que);
            checkNeighbors(image, n, m, i, j+1, flooder, que);
        }

        return image;
    }

    static void checkNeighbors(int[][] image, int n, int m, int x, int y, int p, Queue<Pair> que) {
        if (x >=0 && x < n && y>=0 && y< m && image[x][y] == p) {
            que.offer(new Pair(x, y));
        }
    }

    static class Pair{
        int i, j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
