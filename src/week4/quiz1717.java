package week4;

import java.io.*;
import java.util.StringTokenizer;

public class quiz1717 {
    private static int n, m, a, b, parent[], rank[], op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        makeSet(n);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(op == 0) unionSet(a, b);
            else {
                if(findSet(a) == findSet(b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if (rootU > rootV) parent[rootV] = rootU;
        else if (rootU < rootV) parent[rootU] = rootV;
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    private static int findSet(int u){
        if (parent[u] == u) return u;
        parent[u] = findSet(parent[u]);
        return parent[u];
    }

    private static void makeSet(int u){
        parent = new int[u+1];
        rank = new int[u+1];
        for(int i=0; i<=u; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
}