package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class quiz1197 {
    private static int v, e, a, b, c, edges[][], answer = 0, parent[], count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        List<Edge> arr = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Edge(u, v, w));
        }

        arr.sort((a, b) -> Integer.compare(a.weight, b.weight));

        makeSet(v);

        for (Edge edge : arr){
            if(findSet(edge.u) != findSet(edge.v)){
                unionSet(edge.u, edge.v);
                answer += edge.weight;
            }
        }
        System.out.println(answer);
    }

    static class Edge{
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private static int findSet(int u){
        if(parent[u] == u) return u;
        parent[u] = findSet(parent[u]);
        return parent[u];
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if(rootU > rootV) parent[rootV] = rootU;
        else {
            parent[rootU] = rootV;
        }
    }

    private static void makeSet(int n){
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
    }
}
