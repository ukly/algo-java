package week4;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class quiz4195 {
    private static int t, f, idx, parent[], rank[], idxP1, idxP2, answer;
    private static String  p1, p2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while(t-->0) {
            f = Integer.parseInt(br.readLine());
            parent = new int[f*2];
            rank = new int[f*2];
            for(int i=0; i<f*2; i++){
                parent[i] = i;
                rank[i] = 1;
            }
            idx = 0;
            Map<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                p1 = st.nextToken();
                p2 = st.nextToken();

                if(!hashMap.containsKey(p1)) {
                    hashMap.put(p1, idx);
                    idx++;
                }
                if(!hashMap.containsKey(p2)){
                    hashMap.put(p2, idx);
                    idx++;
                }
                idxP1 = hashMap.get(p1);
                idxP2 = hashMap.get(p2);
                unionSet(idxP1, idxP2);
                bw.write(rank[parent[idxP1]] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void unionSet(int u, int v){
        int rootU = findSet(u);
        int rootV = findSet(v);

        if (rootU != rootV){
            parent[rootV] = rootU;
            rank[rootU] += rank[rootV];
            rank[rootV] = 1;
        }
    }

    private static int findSet(int u){
        if (parent[u] == u) return u;
        return parent[u] = findSet(parent[u]);
    }
}
