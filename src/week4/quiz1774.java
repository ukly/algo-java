package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class quiz1774 {
    private static int n, m, parent[];
    private static double  answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        makeSet(n);

        List<Node> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
        }

        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                double dist = calcDistance(nodes.get(i), nodes.get(j));
                edges.add(new Edge(i, j, dist));
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionSet(a-1, b-1);
        }

        edges.sort((a, b) -> Double.compare(a.weight, b.weight));


        for(Edge edge : edges){
            if(findSet(edge.u) != findSet(edge.v)){
                unionSet(edge.u, edge.v);
                answer += edge.weight;
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    static class Edge{
        int u;
        int v;
        double weight;

        public Edge(int u, int v, double weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class Node{
        double x;
        double y;

        public Node(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private static double calcDistance(Node u, Node v){
        double dx = u.x - v.x;
        double dy = u.y - v.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if(rootU > rootV) parent[rootV] = parent[rootU];
        else parent[rootU] = parent[rootV];
    }

    private static int findSet(int u){
        if (parent[u] == u) return u;
        return parent[u] = findSet(parent[u]);
    }

    private static void makeSet(int n){
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }
}
