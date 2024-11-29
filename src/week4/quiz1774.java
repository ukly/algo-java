package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz1774 {
    private static int n, m, e, parent[], rank[], count =0;
    private static double edges[][], nodes[][], answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        e = n*(n-1)/2;

        edges = new double[e+1][3];
        parent = new int[n+1];
        rank = new int[n+1];
        nodes = new double[n+1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Double.parseDouble(st.nextToken());
            nodes[i][1] = Double.parseDouble(st.nextToken());

            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; i++) { // 무조건 연결해놓기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(findSet(a) != findSet(b)) {
                count++;
                unionSet(a, b);
            }
        }

        int idx = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++){
                edges[idx][0] = i;
                edges[idx][1] = j;
                edges[idx][2] = calcDistance(nodes[i], nodes[j]);
                idx++;
            }
        }
        Arrays.sort(edges, (a, b) -> Double.compare(a[2], b[2]));

        for (int i = 1; i <= e; i++) {
            if(count == n-1) break;
            int a = (int) edges[i][0];
            int b = (int) edges[i][1];
            if(findSet(a) != findSet(b)) {
                answer += edges[i][2];
                count++;
                unionSet(a, b);
            }
        }
        System.out.printf("%.2f\n", answer);
    }

    private static double calcDistance(double[] a, double[] b){
        double dx = a[0] - b[0];
        double dy = a[1] - b[1];
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
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
