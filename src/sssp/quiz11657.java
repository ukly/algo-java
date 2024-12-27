package sssp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class quiz11657 {
    private static int n, m;
    private static long dists[];

    static class Edge{
        int u, v, weight;

        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }

    static boolean bellmanFord(int V, List<Edge> edges, int start){
        dists = new long[V+1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        for(int i=1; i<V; i++){
            for(Edge edge : edges){
                if(!(dists[edge.u]==Integer.MAX_VALUE) && dists[edge.u] + edge.weight < dists[edge.v]){
                    dists[edge.v] = dists[edge.u] + edge.weight;
                 }
            }
        }

        for(Edge edge: edges){
            if(!(dists[edge.u]==Integer.MAX_VALUE) && dists[edge.u] + edge.weight < dists[edge.v]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u,v,w));
        }

        boolean hasShortestPath = bellmanFord(n, edges, 1);

        if(hasShortestPath){
            for (int i = 2; i <= n; i++) {
                if(dists[i]==Integer.MAX_VALUE) bw.write(-1+"\n");
                else bw.write(dists[i] + "\n");
            }
        } else bw.write("-1");

        bw.flush();
        bw.close();
    }
}
