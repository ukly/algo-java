package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class quiz9252 {
    private static String answer = "";
    private static char a[], b[];
    private static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        dp = new int[a.length + 1][b.length + 1];
        int l = lcs(a.length, b.length);
        System.out.println(l);

        if(l != 0) System.out.println(getLcsString(a.length, b.length));
    }

    private static int lcs(int m, int n){
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (a[i-1] == b[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

    private static String getLcsString(int m, int n){
        int i = m;
        int j = n;
        while(i > 0 && j > 0){
            if(dp[i-1][j] == dp[i][j]){
                i--;
            } else if(dp[i][j] == dp[i][j-1]){
                j--;
            } else {
                answer = a[i-1] + answer;
                i--;
                j--;
            }
        }
        return answer;
    }
}
