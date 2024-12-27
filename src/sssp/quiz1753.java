package sssp;

import java.io.*;
import java.util.*;

public class quiz1753 {
    public static int V, E;

    static class Edge implements Comparable<Edge>{
        int index;
        int weight;

        public Edge(int index, int cost){
            this.index = index;
            this.weight = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static int[] dijkstra(int n, List<List<Edge>> graph, int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int currentNode = current.index;
            int currentWeight = current.weight;

            if(currentWeight > dist[currentNode]) continue;;

            for(Edge neighbor : graph.get(currentNode)){
                int nextNode = neighbor.index;
                int nextWeight = neighbor.weight;

                if(dist[currentNode] + nextWeight < dist[nextNode]){
                    dist[nextNode] = nextWeight + dist[currentNode];
                    pq.offer(new Edge(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        int[] dist = dijkstra(V, graph, start);

        for (int i = 1; i < dist.length; i++) {
            String w = dist[i] + "";
            if (dist[i] == Integer.MAX_VALUE) w = "INF";
            bw.write(w + "\n");
        }

        bw.flush();
        bw.close();
    }

}
