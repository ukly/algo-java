package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz1197 {
    private static int v, e, a, b, c, edges[][], answer = 0, parent[], rank[], count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new int[e][3];

        for (int i = 0; i <e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        makeSet(v);

        for (int i = 0; i < e; i++) {
            if(count == v-1) break;
            int a = edges[i][0];
            int b = edges[i][1];
            if(findSet(a) != findSet(b)) {
                answer += edges[i][2];
                count++;
                unionSet(a, b);
            }
        }
        System.out.println(answer);
    }

    private static void makeSet(int s){
        parent = new int[s+1];
        rank = new int[s+1];
        for (int i = 0; i < s+1; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
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
