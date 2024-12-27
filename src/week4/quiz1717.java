package week4;

import java.io.*;
import java.util.StringTokenizer;

public class quiz1717 {
    private static int n, m, a, b, parent[], op;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        makesSet(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(op == 0){
                unionSet(a, b);
            } else {
                int rootA = findSet(a);
                int rootB = findSet(b);
                if(rootA == rootB) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if(rootU > rootV) parent[rootV] = rootU;
        else parent[rootU] = rootV;
    }

    private static int findSet(int u){
        if (parent[u] == u) return u;
        parent[u] = findSet(parent[u]);
        return parent[u];
    }

    private static void makesSet(int n){
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }
}