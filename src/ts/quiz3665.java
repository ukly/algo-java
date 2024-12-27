package ts;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class quiz3665 {
    private static int tc, n, m, t[], d[], result[];
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String answer = "";
            n = Integer.parseInt(br.readLine());
            t = new int[n+1];
            d = new int[n+1];
            result = new int[n];
            Arrays.fill(d, 0);
            Arrays.fill(t, 0);

            //간접리스트 초기화
            adjList = new ArrayList<>();
            for (int i = 0; i <=n; i++) {
                adjList.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <=n; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <n; i++) {
                for (int j = i+1; j <=n; j++) {
                    adjList.get(t[i]).add(t[j]);
                    d[t[i]]++;
                }
            }

            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(adjList.get(a).contains(b)){
                    d[a]--;
                    d[b]++;
                    adjList.get(a).remove((Integer) b);
                    adjList.get(b).add(a);
                } else {
                    d[a]++;
                    d[b]--;
                    adjList.get(b).remove((Integer) a);
                    adjList.get(a).add(b);
                }
            }
            for (int i = 1; i <=n; i++) {
                result[n-d[i]-1] = i;
            }
            for (int i = 0; i <n; i++) {
                answer = answer.concat(result[i] + " ");
            }
            Arrays.sort(d);
            for (int i = 1; i <=n; i++) {
                if(d[i] != i-1) {
                    answer = "IMPOSSIBLE";
                    break;
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
