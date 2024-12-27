package sssp;

import java.io.*;
import java.util.*;

public class quiz1738 {
    private static int n, m, dist[], prevNode[], adjMatrix[][], pathLength=1;
    private static String answer = "";
    private static List<List<Integer>> adjList;

    static class Edge{
        int u, v, weight;

        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }

    private static boolean bellmanFord(int V, List<Edge> edges, int start) {
        dist = new int[V + 1];
        prevNode = new int[V + 1];
        Arrays.fill(prevNode, 0);
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[start] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MIN_VALUE && dist[edge.u] + edge.weight > dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                    prevNode[edge.v] = edge.u;
                }
            }
        }

        if(dfs(n)) return false;

        int idx = V;
        while (idx != 1) {
            idx = prevNode[idx];
            pathLength++;
        }
        return true;
    }

    private static boolean dfs(int k){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        while(!queue.isEmpty()){
            int v = queue.poll();
            List<Integer> adj = adjList.get(v);
            while(!adj.isEmpty()){
                int u = adj.remove(0);
                if (dist[u] != Integer.MIN_VALUE && dist[u] + adjMatrix[u][v] > dist[v]){
                    return true;
                }
                queue.add(u);
            }
        }

        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //간접리스트 초기화
        adjList = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            adjList.add(new ArrayList<>());
        }

        List<Edge> edges = new ArrayList<>();
        adjMatrix = new int[n + 1][n + 1];
        for(int[] mat : adjMatrix){
            Arrays.fill(mat, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
            adjList.get(v).add(u);
            adjMatrix[u][v] = w;
        }


        boolean isAcycle = bellmanFord(n, edges, 1);
        if(isAcycle){
            int idx = n;
            answer = n + "";
            for (int i = 1; i < pathLength; i++) {
                idx = prevNode[idx];
                answer = idx + " " + answer;
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
        bw.flush();
        bw.close();
    }
}
