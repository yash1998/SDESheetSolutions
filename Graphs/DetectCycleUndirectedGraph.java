package Graphs;

import java.util.List;
import java.util.Queue;

public class DetectCycleUndirectedGraph {
    boolean detectCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];

        // DFS based
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }

        // BFS based
        // Queue<Pair> que = new LinkedList<>();
        // for(int i=0; i<V; i++) {
        // if (!vis[i]) {
        // if(bfs(i, -1, vis, adj, que)) return true;
        // }
        // }

        return false;
    }

    boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, node, vis, adj))
                    return true;
            } else {
                if (neighbor != parent)
                    return true;
            }
        }
        return false;
    }

    boolean bfs(int node, int parent, boolean[] vis, List<List<Integer>> adj, Queue<Pair> que) {
        que.offer(new Pair(node, parent));
        while (!que.isEmpty()) {
            Pair p = que.poll();
            vis[p.node] = true;
            for (int neighbor : adj.get(p.node)) {
                if (!vis[neighbor]) {
                    que.offer(new Pair(neighbor, p.node));
                } else {
                    if (neighbor != p.parent)
                        return true;
                }
            }
        }
        return false;
    }

    class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
