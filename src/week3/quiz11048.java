package week3;

import java.io.*;
import java.util.StringTokenizer;

public class quiz11048 {
    private static int n,m;
    private static int[][] maze, dp, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        dp = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(rec(n-1, m-1));
    }

    private static int rec(int r, int c) {
        if (r < 0 || c < 0) return 0;
        if(visited[r][c] == 1) return dp[r][c];
        visited[r][c] = 1;
        dp[r][c] = Math.max(Math.max(rec(r-1, c), rec(r,c-1)), rec(r-1, c-1)) + maze[r][c];
        return dp[r][c];
    }

}
