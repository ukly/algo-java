package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz16562 {
    private static int n, m, k, minIdx, k0;
    private static int parent[], rank[], cost[];
    private static double cpf[], minCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        k0 = k;

        parent = new int[n+1]; rank = new int[n+1]; cost = new int[n+1]; cpf = new double[n+1];

        parent[0] = 0; rank[0] = 1; cost[0] = 0; cpf[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            parent[i] = i;
            rank[i] = 1;
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(parent[i] == i){
                sum += cost[i];
            }
        }
        if(k - sum < 0){
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if (rootU != rootV){
            if(cost[rootU] > cost[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
            }
        }
    }

    private static int findSet(int u){
        if (parent[u] == u) return u;
        return parent[u] = findSet(parent[u]);
    }
}
