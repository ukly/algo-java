package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class quiz2579 {
    private static int n;
    private static int[] dp, stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n];
        stairs = new int[n];

        for(int i=0; i<n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = stairs[0];

        System.out.println(asc(n-1));
    }

    private static int asc(int i){
        if(i < 0) return 0;
        if(dp[i] != 0) return dp[i];

        dp[i] = Math.max(asc(i-3) + stairs[i-1], asc(i-2)) + stairs[i];


        return dp[i];
    }
}
