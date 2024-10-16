package week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz11060 {
    private static int n, jumps;
    private static int[] maze, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        maze = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            maze[i] = Integer.parseInt(st.nextToken());
        }

        // i는 점프를 시작하는 위치, j는 점프해서 도착할 수 있는 거리
        for(int i=0; i<n-1; i++) {
            if (dp[i] == 0 && i != 0) continue;
            for (int j = 1; j <= maze[i]; j++) {
                if (i + j > n - 1) break;
                if (dp[i] + 1 < dp[i + j] || dp[i + j] == 0) {
                    dp[i + j] = dp[i] + 1;
                }
            }
        }
        if(n==1) {
            System.out.println(0);
        } else if(dp[n-1] == 0){
            System.out.println(-1);
        } else {
            System.out.println(dp[n-1]);
        }
    }
}
