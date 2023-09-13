package Graphs;

import java.util.*;

public class DFS_BFS {

    // Time: O(N), Space: undirected - O(2*E) - fn call stack
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = buildAdjList(v, e, edges);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> components = new ArrayList<>();
                dfs(i, adj, visited, components);
                res.add(components);
            }
        }

        return res;
    }

    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        visited[node] = true;
        list.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, list);
            }
        }
    }

    public static List<List<Integer>> buildAdjList(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        return adjList;
    }

    // Time: O(N), Space: undirected - O(2*E) - que
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[n];

        que.add(0);
        vis[0] = true;

        while (!que.isEmpty()) {
            int u = que.poll();
            bfs.add(u);
            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    que.add(v);
                    vis[v] = true;
                }
            }
        }

        return bfs;
    }
}
