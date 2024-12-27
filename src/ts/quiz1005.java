package ts;

import java.io.*;
import java.util.*;

public class quiz1005 {
    private static int t[], target, dp[];
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            t = new int[n+1];
            dp = new int[n+1];
            Arrays.fill(t, 0);
            Arrays.fill(dp, -1);

            adjList = new ArrayList<>();
            for (int i = 0; i <=n; i++) {
                adjList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                adjList.get(v).add(u);
            }
            target = Integer.parseInt(br.readLine());
            bw.write(dfs(target) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int dfs(int n){
        if(dp[n] != -1) return dp[n];
        List<Integer> adj = adjList.get(n);
        if(adj.isEmpty()){
            return t[n];
        } else if (adj.size() == 1) {
            dp[n] = dfs(adj.get(0)) + t[n];
            return dp[n];
        } else {
            int max = -1;
            for(Integer i : adj){
                int prev = dfs(i);
                if(prev > max) max = prev;
            }
            dp[n] = max + t[n];
            return dp[n];
        }
    }
}
