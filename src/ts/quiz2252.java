package ts;

import java.io.*;
import java.util.*;

public class quiz2252 {
    private static int n, m, d[];

    private static List<Integer> kahn(int V, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            if(d[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int u = queue.poll();
            result.add(u);

            for(int neighbor : graph.get(u)){
                d[neighbor] -= 1;
                if(d[neighbor] == 0) queue.add(neighbor);
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new int[n+1];
        Arrays.fill(d, 0);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            d[b]++;
        }

        List<Integer> result = kahn(n, graph);

        for (int i = 1; i <= n; i++) {
            bw.write(result.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }
}
