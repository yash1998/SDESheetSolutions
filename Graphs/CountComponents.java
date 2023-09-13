package Graphs;

import java.util.*;

public class CountComponents {

    public static int findNumOfProvinces(int[][] roads, int v) {

        int count = 0;
        boolean visited[] = new boolean[v];

        // DFS
        // ArrayList<ArrayList<Integer>> adj = buildAdj(roads, v);
        // for(int i=0; i<v; i++) {
        // if(!visited[i]) {
        // count++;
        // dfs(i, adj, visited);
        // }
        // }

        // BFS
        // ArrayList<ArrayList<Integer>> adj = buildAdj(roads, v);
        // Queue<Integer> que = new LinkedList<>();
        // for(int i=0; i<v; i++) {
        // if (visited[i]) continue;
        // que.offer(i);
        // visited[i] = true;
        // while(!que.isEmpty()) {
        // int node = que.poll();
        // for(int neighbor: adj.get(node)) {
        // if (!visited[neighbor]) {
        // que.offer(neighbor);
        // visited[neighbor] = true;
        // }
        // }
        // }
        // count++;
        // }

        // Without building adj list
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (visited[i])
                continue;
            que.offer(i);
            visited[i] = true;
            while (!que.isEmpty()) {
                int node = que.poll();
                for (int neighbor = 0; neighbor < v; neighbor++) {
                    if (roads[node][neighbor] == 1 && !visited[neighbor]) {
                        que.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            count++;
        }

        return count;
    }

    // public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
    //     visited[node] = true;
    //     for (int neighbor : adj.get(node)) {
    //         if (!visited[neighbor]) {
    //             dfs(neighbor, adj, visited);
    //         }
    //     }
    // }

    // public static ArrayList<ArrayList<Integer>> buildAdj(int[][] isConnected, int v) {
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    //     for (int i = 0; i < v; i++) {
    //         adj.add(new ArrayList<>());
    //     }

    //     for (int i = 0; i < v; i++) {
    //         for (int j = 0; j < v; j++) {
    //             if (i != j && isConnected[i][j] == 1) {
    //                 adj.get(i).add(j);
    //             }
    //         }
    //     }

    //     return adj;
    // }
}
