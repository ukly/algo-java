package week3;

import java.io.*;
import java.util.StringTokenizer;

public class quiz11726 {
    private static int n;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dp = new int[2][n];



        if(n==1) System.out.println(1);
        else if (n==2) System.out.println(2);
        else {
            dp[0][0] = 1;
            dp[1][0] = 0;
            dp[0][1] = 1;
            dp[1][1] = 1;
            for (int i=2; i<n; i++){
                dp[0][i] = (dp[0][i-1] + dp[1][i-1])%10007;
                dp[1][i] = (dp[0][i-2] + dp[1][i-2])%10007;
            }
            System.out.println((dp[0][n-1] + dp[1][n-1])%10007);
        }
    }
}
