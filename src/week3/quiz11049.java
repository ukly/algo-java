package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz11049 {
    private static int n;
    private static int dp[][], p[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1][n+1];

        p = new int[n+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            if(i==n-1) p[i+1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(s(0, n));
    }

    private static int s(int s, int e){
        if (e - s == 1) return 0;
        if (dp[s][e] != 0) return dp[s][e];

        int size = Integer.MAX_VALUE;
        for(int i=s+1; i<e; i++){
            size = Math.min(size, s(s, i) + s(i, e) + p[s]*p[i]*p[e]);
        }

        dp[s][e] = size;

        return size;
    }
}
