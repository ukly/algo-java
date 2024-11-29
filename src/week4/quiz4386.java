package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz4386 {
    private static int n, e, parent[], rank[], count =0;
    private static double edges[][], nodes[][], answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        e = n*(n-1)/2;

        edges = new double[e][3];
        parent = new int[n];
        rank = new int[n];
        nodes = new double[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Double.parseDouble(st.nextToken());
            nodes[i][1] = Double.parseDouble(st.nextToken());

            parent[i] = i;
            rank[i] = 0;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++){
                edges[idx][0] = i;
                edges[idx][1] = j;
                edges[idx][2] = calcDistance(nodes[i], nodes[j]);
                idx++;
            }
        }
        Arrays.sort(edges, (a, b) -> (int)(a[2] - b[2]));

        for (int i = 0; i < e; i++) {
            if(count == n-1) break;
            int a = (int) edges[i][0];
            int b = (int) edges[i][1];
            if(findSet(a) != findSet(b)) {
                answer += edges[i][2];
                count++;
                unionSet(a, b);
            }
        }
        System.out.println(Math.round(answer*100)/100.0);
    }

    private static double calcDistance(double[] a, double[] b){
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        return Math.sqrt(dx*dx + dy*dy);
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if (rootU != rootV){
            if(rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]){
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    private static int findSet(int u){
        if (parent[u] == u) return u;
        return parent[u] = findSet(parent[u]);
    }
}
