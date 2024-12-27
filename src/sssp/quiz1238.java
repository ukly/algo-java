package sssp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class quiz1238 {
    private static int n, m, x, max = -1;

    static class Edge implements Comparable<Edge> {
        int index;
        int weight;

        public Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static int[] dijkstra(int n, List<List<Edge>> graph, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.index;
            int currentWeight = current.weight;

            if (dist[currentNode] < currentWeight) continue;

            for (Edge neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.index;
                int nextWeight = neighbor.weight;

                if (dist[nextNode] > dist[currentNode] + nextWeight) {
                    dist[nextNode] = dist[currentNode] + nextWeight;
                    pq.offer(new Edge(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        for (int i = 1; i <= n; i++) {
            int distGo[] = dijkstra(n, graph, i);
            int distBack[] = dijkstra(n, graph, x);
            int totalDist = distGo[x] + distBack[i];
            if (max < totalDist) max = totalDist;
        }

        System.out.println(max);
    }
}
